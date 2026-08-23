import java.util.*;

class Solution {

  private Map<String, Integer> memo;

  private int solve(int n, String oschs, String ctrlCV, int nops) {
    String key = oschs + "#" + ctrlCV;
    if (this.memo.containsKey(key)) return this.memo.get(key);
    // System.out.println(oschs + " " + nops);
    if (n == oschs.length()) {
      this.memo.put(key, nops);
      return nops;
    }
    if (n < oschs.length() || nops > n) {
      this.memo.put(key, Integer.MAX_VALUE);
      return Integer.MAX_VALUE;
    }

    // copy
    int copy = Integer.MAX_VALUE;
    if (!oschs.equals(ctrlCV)) copy = solve(n, oschs, oschs, nops + 1);

    // paste
    int paste = Integer.MAX_VALUE;
    if (!ctrlCV.isEmpty()) paste = solve(n, oschs + ctrlCV, ctrlCV, nops + 1);

    int ops = Math.min(copy, paste);
    this.memo.put(key, ops);
    return ops;
  }

  public int minSteps(int n) {
    this.memo = new HashMap<>();
    String onScreenChars = "A";
    String ctrl_cv_buf = new String();
    int nops = 0; //number of operations
    return solve(n, onScreenChars, ctrl_cv_buf, nops);
  }
}

public class _650_2_Keys_Keyboard {

  public static void main(String[] args) {
    System.out.println(new Solution().minSteps(5));
  }
}
