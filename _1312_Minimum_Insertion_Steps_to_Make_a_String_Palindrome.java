class Solution {

  private int solve(int i, int j, String s, Integer[][] cache) {
    if (i > j) return 0;
    if (cache[i][j] != null) return cache[i][j];
    if (s.charAt(i) == s.charAt(j)) return cache[i][j] = solve(
      i + 1,
      j - 1,
      s,
      cache
    );
    return cache[i][j] = (1 +
      Math.min(solve(i + 1, j, s, cache), solve(i, j - 1, s, cache)));
  }

  public int minInsertions(String s) {
    int i = 0;
    int j = s.length() - 1;

    Integer[][] cache = new Integer[j + 1][j + 1];
    return solve(i, j, s, cache);
  }
}

public class _1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().minInsertions("leetcode"));
    System.out.println(new Solution().minInsertions("mbadm"));
    System.out.println(new Solution().minInsertions("zjveiiwvc"));
  }
}
