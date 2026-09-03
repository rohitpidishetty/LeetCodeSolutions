import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> buff = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] ch = strs[i].toCharArray();
      Arrays.sort(ch);
      buff
        .computeIfAbsent(new String(ch), key -> new ArrayList<>())
        .add(strs[i]);
    }
    return new ArrayList<>(buff.values());
  }
}

public class _49_Group_Anagrams {

  public static void main(String[] args) {
    System.out.println(
      new Solution().groupAnagrams(
        new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }
      )
    );
  }
}
