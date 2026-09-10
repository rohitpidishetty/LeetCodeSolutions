import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    int n = nums.length;
    Map<Integer, List<Integer>> subSeq = new HashMap<>();
    for (; i < n; i++) subSeq.put(i, new ArrayList<>());
    int[] currLen = new int[n];
    Arrays.fill(currLen, 0);
    int max = 0;
    int maxAt = 0;
    i = 1;
    for (; i < n; i++) {
      int choice = -1;
      int len = currLen[i];
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && currLen[j] >= len) {
          choice = j;
          len = currLen[j];
        }
      }
      if (choice > -1) {
        subSeq.get(i).add(nums[choice]);
        subSeq.get(i).addAll(subSeq.get(choice));
        currLen[i] = subSeq.get(i).size();
        if (currLen[i] > max) {
          max = currLen[i];
          maxAt = i;
        }
      }
    }

    subSeq.get(maxAt).add(nums[maxAt]);

    return subSeq.get(maxAt);
  }
}

public class _368_Largest_Divisible_Subset {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestDivisibleSubset(new int[] { 1, 2, 3, 4, 8, 9, 72 })
    );
    System.out.println(
      new Solution().largestDivisibleSubset(new int[] { 1, 2, 4, 8 })
    );
  }
}
