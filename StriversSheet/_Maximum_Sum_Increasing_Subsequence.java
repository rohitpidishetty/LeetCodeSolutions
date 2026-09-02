import java.util.HashMap;
import java.util.Map;

class Solution {

  public int maxSumIncreasingSubsequence(int[] arr, int n) {
    Map<Integer, Integer> maxSum = new HashMap<>();
    int globalMax = 0;
    for (int i = 0; i < arr.length; i++) {
      int maxSumSoFar = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) maxSumSoFar = Math.max(maxSumSoFar, maxSum.get(j));
      }
      maxSum.put(i, maxSumSoFar + arr[i]);
      globalMax = Math.max(globalMax, maxSumSoFar + arr[i]);
    }
    return globalMax;
  }
}

public class _Maximum_Sum_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxSumIncreasingSubsequence(new int[] { 4, 1, 2, 3 }, 6)
    );
  }
}
