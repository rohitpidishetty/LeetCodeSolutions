import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Solution {

  public int numMatchingSubseq(String s, String[] words) {
    Map<Character, TreeSet<Integer>> positions = new HashMap<>();
    int n = s.length();
    int count = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (!positions.containsKey(ch)) positions.put(ch, new TreeSet<>());
      positions.get(ch).add(i);
    }
    for (String word : words) {
      n = word.length();
      boolean status = true;

      int lastMarked = -1;
      for (int i = 0; i < n; i++) {
        char ch = word.charAt(i);
        if (!positions.containsKey(ch)) {
          status = false;
          break;
        }
        TreeSet<Integer> seq = positions.get(ch);

        Integer ceil = seq.ceiling(lastMarked + 1);
        if (ceil == null || ceil == lastMarked) {
          status = false;
          break;
        }
        lastMarked = ceil;
      }
      if (status) count++;
    }
    return count;
  }
}

public class _792_Number_of_Matching_Subsequences {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numMatchingSubseq(
        "qlhxagxdqh",
        new String[] { "qlhxagxdq", "qlhxagxdq", "lhyiftwtut", "yfzwraahab" }
      )
    );
    System.out.println();
    System.out.println(
      new Solution().numMatchingSubseq(
        "abcde",
        new String[] { "a", "bb", "acd", "ace" }
      )
    );
    System.out.println();
    System.out.println(
      new Solution().numMatchingSubseq(
        "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac",
        new String[] {
          "wpddkvbnn",
          "lnagtva",
          "kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju",
          "rwpddkvbnnugln",
          "gloeofnpjqlkdsqvruvabjrikfwronbrdyyj",
          "vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos",
          "mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina",
          "rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip",
          "fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq",
          "qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx",
        }
      )
    );
  }
}
