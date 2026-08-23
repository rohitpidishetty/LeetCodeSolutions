import java.util.ArrayList;
import java.util.List;

class Solution {
  public String[] findWords(String[] words) {
    String[] keyboard = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
    List<String> result = new ArrayList<>();
    for (String word : words) {
      int row = 0;
      int chIdx = 0;
      boolean state = true;
      for (char ch : word.toLowerCase().toCharArray()) {
        String ch_s = String.valueOf(ch);
        if (chIdx == 0) {
          if (keyboard[0].contains(ch_s))
            row = 0;
          else if (keyboard[1].contains(ch_s))
            row = 1;
          else if (keyboard[2].contains(ch_s))
            row = 2;
        } else {
          if (!keyboard[row].contains(ch_s))
            state = false;
        }
        chIdx++;
      }
      if (state)
        result.add(word);
    }

    return result.toArray(new String[result.size()]);
  }
}

public class _500_Keyboard_Row {
  public static void main(String[] args) {
    System.out.println(new Solution().findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" }));
  }
}
