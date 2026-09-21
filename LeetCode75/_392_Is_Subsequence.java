class Solution {

  public boolean isSubsequence(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n > m) return false;
    if (n == 0) return true;
    if (m == 0) return false;
    int limit = Math.max(n, m);
    int min = Math.min(m, n);

    int i = 0;
    int lazyIdx = 0;

    while (i < limit) {
      if (s.charAt(lazyIdx) == t.charAt(i)) lazyIdx++;
      if (lazyIdx >= min) return true;
      i++;
    }

    return false;
  }
}

public class _392_Is_Subsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
  }
}
