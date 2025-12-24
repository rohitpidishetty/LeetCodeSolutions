import java.util.Arrays;

class Solution {

  public char findTheDifference(String s, String t) {
    char[] s_tokens = s.toCharArray();
    char[] t_tokens = t.toCharArray();
    Arrays.sort(s_tokens);
    Arrays.sort(t_tokens);
    int i = 0, j = 0;
    while (i < s_tokens.length && j < t_tokens.length) {
      if (s_tokens[i] == t_tokens[j]) {
        i++;
        j++;
      } else return t_tokens[j];
    }
    return t_tokens[i];
  }
}

public class _389_Find_the_Difference {

  public static void main(String[] args) {
    System.out.println(new Solution().findTheDifference("abcd", "abcde"));
  }
}
