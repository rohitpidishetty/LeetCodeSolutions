import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public boolean closeStrings(String word1, String word2) {
    int w1[] = new int[26];
    int w2[] = new int[26];
    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();
    for (char ch : word1.toCharArray()) {
      set1.add(ch);
      w1[ch - 'a']++;
    }
    for (char ch : word2.toCharArray()) {
      set2.add(ch);
      w2[ch - 'a']++;
    }
    if (!set1.equals(set2)) return false;
    Arrays.sort(w1);
    Arrays.sort(w2);

    return Arrays.equals(w1, w2);
  }
}

public class _1657_Determine_if_Two_Strings_Are_Close {

  public static void main(String[] args) {
    System.out.println(new Solution().closeStrings("abc", "bca"));
  }
}
