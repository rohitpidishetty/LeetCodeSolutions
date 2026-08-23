import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {

  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> freq = new HashMap<>();
    String[] s1Words = s1.split(" ");

    String[] s2Words = s2.split(" ");

    for (String wrd : s1Words) freq.put(wrd, freq.getOrDefault(wrd, 0) + 1);
    for (String wrd : s2Words) freq.put(wrd, freq.getOrDefault(wrd, 0) + 1);

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> map : freq.entrySet()) {
      if (map.getValue() == 1) sb.append(map.getKey()).append(",");
    }
    String[] res = sb.toString().split(",");
    return res[0].equals("") ? new String[] : res;
  }
}

public class _884_Uncommon_Words_from_Two_Sentences {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().uncommonFromSentences(
          "this apple is sweet",
          "this apple is sour"
        )
      )
    );
    System.out.println(
      Arrays.toString(
        new Solution().uncommonFromSentences("apple apple", "banana")
      )
    );
    System.out.println(
      Arrays.toString(
        new Solution().uncommonFromSentences("fd kss fd", "fd fd kss")
      )
    );
  }
}
