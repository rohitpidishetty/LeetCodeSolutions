import java.util.*;

class Solution {

  public int[] constructArray(int n, int k) {
    int ret[] = new int[n];
    int low = 1, high = n;
    boolean highAlteredAtLast = false;
    int i = 0;
    while (k > 0) {
      ret[i++] = (!highAlteredAtLast) ? high-- : low++;
      highAlteredAtLast = !highAlteredAtLast;
      k--;
    }
    if (!highAlteredAtLast) while (i < n) ret[i++] = low++;
    else while (i < n) ret[i++] = high--;

    return ret;
  }
}

public class _667_Beautiful_Arrangement_II {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().constructArray(9, 5)));
  }
}
