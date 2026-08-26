import java.util.Arrays;

class Solution {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int i = 0;
    int j = 0;
    for (; i < g.length; i++) {
      while (j < s.length && s[j] < g[i]) j++;
      j++;
      if (j > s.length) break;
    }
    return i;
  }
}

public class _455_Assign_Cookies {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findContentChildren(
        new int[] { 1, 2, 3 },
        new int[] { 1, 1 }
      )
    );
  }
}
