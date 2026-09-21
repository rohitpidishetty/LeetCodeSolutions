class Solution {

  public String mergeAlternately(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int i = 0;
    int j = 0;
    StringBuilder sb = new StringBuilder();
    while (i < n && j < m) {
      if (i == j || i < j) sb.append(word1.charAt(i++));
      else sb.append(word2.charAt(j++));
    }
    while (i < n) sb.append(word1.charAt(i++));
    while (j < m) sb.append(word2.charAt(j++));
    return sb.toString();
  }
}

public class _1768_Merge_Strings_Alternately {

  public static void main(String[] args) {
    System.out.println(new Solution().mergeAlternately("ab", "pqrs"));
  }
}
