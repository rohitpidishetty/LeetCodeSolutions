import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

class Solution {

  public int minimumLengthEncoding(String[] words) {
    Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));
    Set<String> group = new HashSet<>();
    for (String wrd : words) group.add(wrd);
    for (String word : words) {
      int n = word.length();
      for (int i = 0; i < n - 1; i++) group.remove(word.substring(i + 1));
    }

    int n = group.size();
    int len = 0;
    for (String s : group) len += s.length() + 1;

    return len;
  }
}

public class _820_Short_Encoding_of_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minimumLengthEncoding(
        new String[] { "time", "time", "time", "time" }
      )
    );
  }
}
