import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    boolean[] present = new boolean[n];

    List<Integer> buffer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (present[nums[i] - 1] == false) present[nums[i] - 1] = true;
      else buffer.add(nums[i]);
    }
    return buffer;
  }
}

public class _442_Find_All_Duplicates_in_an_Array {

  public static void main(String[] args) {
    System.out.println(new Solution().findDuplicates(new int[] { 1, 1, 2 }));
  }
}
