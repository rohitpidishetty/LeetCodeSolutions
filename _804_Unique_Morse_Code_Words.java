import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int uniqueMorseRepresentations(String[] words) {
    String[] morse = {
      ".-",
      "-...",
      "-.-.",
      "-..",
      ".",
      "..-.",
      "--.",
      "....",
      "..",
      ".---",
      "-.-",
      ".-..",
      "--",
      "-.",
      "---",
      ".--.",
      "--.-",
      ".-.",
      "...",
      "-",
      "..-",
      "...-",
      ".--",
      "-..-",
      "-.--",
      "--..",
    };
    Set<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder code = new StringBuilder();
      for (char ch : word.toCharArray()) code.append(morse[ch - 'a']);
      set.add(code.toString());
    }
    return set.size();
  }
}

public class _804_Unique_Morse_Code_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution().uniqueMorseRepresentations(
        new String[] { "gin", "zen", "gig", "msg" }
      )
    );
  }
}
