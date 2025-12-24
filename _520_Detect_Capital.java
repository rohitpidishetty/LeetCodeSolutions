class Solution {
  public boolean detectCapitalUse(String word) {
    int idx = 0, cap_detected_at = -1;
    boolean cap = false, lwr = false, upr = false;
    for (char ch : word.toCharArray()) {
      int ascii = (int) ch;
      if (ascii >= 65 && ascii <= 90) {
        cap = true;
        upr = true;
        cap_detected_at = idx;
      } else if (ascii >= 97 && ascii <= 122)
        lwr = true;
      idx++;
    }

    if (!cap && !upr && lwr)
      return true;
    if (cap && upr && !lwr)
      return true;
    if (cap && upr && lwr && cap_detected_at == 0)
      return true;
    return false;
  }
}

public class _520_Detect_Capital {
  public static void main(String[] args) {
    System.out.println(new Solution().detectCapitalUse("FlaG"));
  }
}
