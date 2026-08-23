import java.util.ArrayList;
import java.util.Collections;

class Solution {

  private String solve(String s, int i, int j) {
    if (i > j) return "";

    int c = 0;
    int S = -1;
    ArrayList<String> list = new ArrayList<>();
    for (int k = i; k <= j; k++) {
      if (s.charAt(k) == '1') {
        if (c == 0) S = k;
        c++;
      } else c--;

      if (c == 0) {
        list.add("1" + solve(s, S + 1, k - 1) + "0");
        S = k + 1;
      }
    }

    Collections.sort(list, Collections.reverseOrder());

    return String.join("", list);
  }

  public String makeLargestSpecial(String s) {
    return solve(s, 0, s.length() - 1);
  }
}

public class _761_Special_Binary_String {

  public static void main(String[] args) {
    System.out.println(new Solution().makeLargestSpecial("11011000"));
  }
}
