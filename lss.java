import java.util.HashSet;
import java.util.Set;

public class lss {
  private int lss_(String s) {
    char[] ch = s.toCharArray();

    int lp = 0;
    int rp = 0;
    int maxLen = 0;
    Set<Character> set = new HashSet<>();

    while (rp < ch.length) {
      while (set.contains(ch[rp])) {
        set.remove(ch[lp]);
        lp++;
      }
      set.add(ch[rp]);
      maxLen = Math.max(maxLen, rp - lp + 1);
      rp++;
    }

    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(new lss().lss_("abccbcbbbb"));
  }

}
