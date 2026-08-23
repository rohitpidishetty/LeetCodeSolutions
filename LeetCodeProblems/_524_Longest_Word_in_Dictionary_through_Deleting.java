import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  // // 10 / 31 testcases passed
  // public String findLongestWord(String s, List<String> dictionary) {
  // int index;
  // return solve(s, new StringBuilder(), index = 0, s.length(), dictionary);
  // }

  // private String solve(String s, StringBuilder sb, int idx, int lim,
  // List<String> dictionary) {
  // String word = sb.toString();
  // if (idx == lim)
  // return !dictionary.contains(word) ? new String() : word
  // // skip
  // String skip = solve(s, sb, idx + 1, lim, dictionary);
  // // take
  // String take = solve(s, sb.append(s.charAt(idx)), idx + 1, lim, dictionary);
  // sb.deleteCharAt(sb.length() - 1);
  // int skip_len = skip.length(), take_len = take.length();
  // return (skip_len > take_len) ? skip : take;
  // }

  private boolean isSubSeq(String a, String b) {
    int i = 0, j = 0, a_lim = a.length(), b_lim = b.length();

    while (i < a_lim && j < b_lim) {
      if (a.charAt(i) == b.charAt(j))
        i++;
      j++;
    }
    return i == a_lim;
  }

  public String findLongestWord(String s, List<String> dictionary) {

    dictionary.sort((a, b) -> a.compareTo(b));

    String max = new String();
    int max_num = 0;
    for (String word : dictionary) {
      int word_len = word.length();
      if (isSubSeq(word, s) && word_len > max_num) {
        max_num = word_len;
        max = word;
      }
    }
    return max;
  }
}

public class _524_Longest_Word_in_Dictionary_through_Deleting {
  public static void main(String[] args) {
    System.out.println(new Solution().findLongestWord("abce", Arrays.asList("abe", "abc")));
  }
}
