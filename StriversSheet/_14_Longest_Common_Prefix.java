class Solution {

  public String longestCommonPrefix(String[] strs) {
    Character ch = null;
    int minString = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      minString = Math.min(minString, strs[i].length());
    }

    int i = 0;
    int res = 0;

    for (; i < minString; i++) {
      int counter = 0;
      for (String str : strs) {
        if (ch == null) ch = str.charAt(i);
        else if (ch != str.charAt(i)) break;
        counter++;
      }
      ch = null;
      if (counter == strs.length) res = i + 1;
      else break;
    }
    return strs[0].substring(0, res);
  }
}

public class _14_Longest_Common_Prefix {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestCommonPrefix(
        new String[] { "flower", "flow", "flight" }
      )
    );
  }
}
