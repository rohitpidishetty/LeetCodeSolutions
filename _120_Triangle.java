import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private static int[][] memo;

  private int recFn(int index, List<List<Integer>> tri, int n, int level) {
    if (level == n - 1)
      return tri.get(level).get(index);
    int currentNodeVal = tri.get(level).get(index);
    int leftTreeVal = Solution.memo[index][level + 1] == Integer.MAX_VALUE ? recFn(index, tri, n, level + 1)
        : Solution.memo[index][level + 1];
    Solution.memo[index][level + 1] = leftTreeVal;
    int rightTreeVal = Solution.memo[index + 1][level + 1] == Integer.MAX_VALUE ? recFn(index + 1, tri, n, level + 1)
        : Solution.memo[index + 1][level + 1];
    Solution.memo[index + 1][level + 1] = rightTreeVal;
    return currentNodeVal + Math.min(leftTreeVal, rightTreeVal);
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    Solution.memo = new int[n][n];
    for (int[] row : Solution.memo)
      Arrays.fill(row, Integer.MAX_VALUE);
    return recFn(0, triangle, n, 0);
  }
}

public class _120_Triangle {
  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(new ArrayList<>(Arrays.asList(-1)));
    triangle.add(new ArrayList<>(Arrays.asList(2, 3)));
    triangle.add(new ArrayList<>(Arrays.asList(1, -1, -3)));
    System.out.println(new Solution().minimumTotal(triangle));
  }
}