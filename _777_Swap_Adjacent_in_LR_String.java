import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  public boolean canTransform(String start, String result) {
    int n = start.length();

    if (!start.replace("X", "").equals(result.replace("X", ""))) return false;

    int i = 0, j = 0;
    while (i < n && j < n) {
      while (i < n && start.charAt(i) == 'X') i++;
      while (j < n && result.charAt(j) == 'X') j++;
      System.out.println(i + " " + j);

      if (i == n || j == n) break;

      char c1 = start.charAt(i);
      char c2 = result.charAt(j);

      if (c1 != c2) return false;
      if (c1 == 'L' && i < j) return false;
      if (c1 == 'R' && i > j) return false;

      i++;
      j++;
    }

    return true;
  }
}

public class _777_Swap_Adjacent_in_LR_String {

  public static void main(String[] args) {
    System.out.println(new Solution().canTransform("RXXLRXRXL", "XRLXXRRLX"));
  }
}
