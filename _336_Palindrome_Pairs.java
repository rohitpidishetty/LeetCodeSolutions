import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public List<List<Integer>> palindromePairs(String[] words) {
    /**
     * What is a palindrome ?
     * Ans: A palindrome is a string that can be read as same on reversing it.
     * Idea?: 'maam' this word can be split at 'ma' - 'am', which implies that is leaves no string when broken.
     * 'madam' when broken leaves a string 'd', the core idea here is to have any string of any length to be
     * a perfect palindrome and the suffix should be present as prefix in a reverse order.
     * Example: 'racecar' => (Prefix)'rac' | 'e' | 'car' (Suffix)
     */

    int idx = 0;
    Map<String, Integer> hmap = new HashMap<>();
    for (String word : words) {
      char[] tokens = word.toCharArray();
      int n = tokens.length;
      int length = n / 2;
      int j = n - 1;
      int i = 0;
      while (i < length && i < j) {
        char temp = tokens[i];
        tokens[i] = tokens[j];
        tokens[j] = temp;
        i++;
        j--;
      }
      hmap.put(new String(tokens), idx++);
    }

    int indx = 0;
    Set<List<Integer>> buffer = new HashSet<>();
    for (String word : words) {
      int n = word.length();
      for (int i = 0; i <= n; i++) {
        String STRING = word.substring(0, i);
        String SUFFIX = word.substring(i, n);
        if (isPalindrome(STRING) && hmap.containsKey(SUFFIX)) {
          int index = hmap.get(SUFFIX);
          if (index != indx) buffer.add(Arrays.asList(index, indx));
        }
        if (isPalindrome(SUFFIX) && hmap.containsKey(STRING)) {
          int index = hmap.get(STRING);
          if (index != indx) buffer.add(Arrays.asList(indx, index));
        }
      }
      indx++;
    }
    return new ArrayList<>(buffer);
  }

  protected boolean isPalindrome(String word) {
    int i = 0;
    int j = word.length() - 1;
    while (i <= j) if (word.charAt(i++) != word.charAt(j--)) return false;
    return true;
  }
}

public class _336_Palindrome_Pairs {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" })
    );
  }
}
