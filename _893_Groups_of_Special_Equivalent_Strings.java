import java.util.*;

class Solution {

  public int numSpecialEquivGroups(String[] words) {
    Set<String> set = new HashSet<>();

    for (String w : words) {
      int n = w.length();
      char[] even = new char[(n + 1) / 2];
      char[] odd = new char[n / 2];

      int e = 0,
        o = 0;

      for (int i = 0; i < w.length(); i++) {
        if (i % 2 == 0) even[e++] = w.charAt(i);
        else odd[o++] = w.charAt(i);
      }

      Arrays.sort(even);
      Arrays.sort(odd);

      set.add(new String(even) + "|" + new String(odd));
    }

    return set.size();
  }
}

public class _893_Groups_of_Special_Equivalent_Strings {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numSpecialEquivGroups(
        new String[] { "abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx" }
      )
    );
  }
}
