import java.util.Arrays;

class Solution {

  public int findLUSlength(String[] strs) {
    Arrays.sort(strs, (a, b) -> b.length() - a.length());
    int n = strs.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if (i == j)
          continue;
        if (isSubSeq(strs[i], strs[j])) {
          flag = false;
          break;
        }
      }
      if (flag)
        return strs[i].length();
    }
    return -1;
  }

  private boolean isSubSeq(String s1, String s2) {
    int i = 0, j = 0, s1_lim = s1.length(), s2_lim = s2.length();
    while (i < s1_lim && j < s2_lim) {
      if (s1.charAt(i) == s2.charAt(j))
        i++;
      j++;
    }
    return i == s1_lim;
  }
}

public class _522_Longest_Uncommon_Subsequence_II {
  public static void main(String[] args) {
    System.out.println(new Solution().findLUSlength(new String[] { "abax", "cdc", "eae" }));
  }
}
