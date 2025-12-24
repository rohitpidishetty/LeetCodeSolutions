class Solution {
  private static int n = 0;
  private static int o = 0;
  private static int p = 0;

  private static boolean[][][] memo;
  private static boolean[][][] vis;

  private boolean fn(String s1, String s2, String fs, int i, int j, int k) {
    if (i == n && j == o && k == p)
      return true;

    if (Solution.vis[i][j][k])
      return Solution.memo[i][j][k];
    boolean ret = false;
    if (k < p && i < n && s1.charAt(i) == fs.charAt(k))
      ret = fn(s1, s2, fs, i + 1, j, k + 1);

    if (k < p && j < o && s2.charAt(j) == fs.charAt(k))
      ret |= fn(s1, s2, fs, i, j + 1, k + 1);

    Solution.memo[i][j][k] = ret;
    Solution.vis[i][j][k] = true;

    return ret;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    Solution.n = s1.length();
    Solution.o = s2.length();
    Solution.p = s3.length();
    Solution.memo = new boolean[101][101][201];
    Solution.vis = new boolean[101][101][201];
    return fn(s1, s2, s3, 0, 0, 0);
  }
}

public class _97_Interleaving_Strings {
  public static void main(String[] args) {
    System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}