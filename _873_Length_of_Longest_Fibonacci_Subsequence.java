import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  private int dfs(
    int[] arr,
    int C,
    int B,
    Map<Integer, Integer> map,
    int[][] memo
  ) {
    if (memo[B][C] != -1) return memo[B][C];
    int A = arr[C] - arr[B];
    if (map.containsKey(A) && map.get(A) < B) {
      return memo[B][C] = dfs(arr, B, map.get(A), map, memo) + 1;
    }
    return memo[B][C] = 2;
  }

  public int lenLongestFibSubseq(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    int max = 0;
    for (int ele : arr) map.put(ele, idx++);
    int n = arr.length;
    int cache[][] = new int[n][n];
    for (int[] memo : cache) Arrays.fill(memo, -1);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        max = Math.max(max, dfs(arr, j, i, map, cache));
      }
    }
    return max >= 3 ? max : 0;
  }
}

public class _873_Length_of_Longest_Fibonacci_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().lenLongestFibSubseq(new int[] { 1, 3, 5 })
    );
    System.out.println(
      new Solution().lenLongestFibSubseq(
        new int[] { 2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34 }
      )
    );
  }
}
