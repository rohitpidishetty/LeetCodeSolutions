import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  private int solve(int n, int idx, int[] buffer, boolean[] used) {
    if (idx == n)
      return 1;

    int ret = 0;
    for (int i = 1; i <= n; i++) {
      if (used[i] || (i % (idx + 1) != 0) && ((idx + 1) % i != 0))
        continue;
      buffer[idx] = i;
      used[i] = true;
      ret += solve(n, idx + 1, buffer, used);
      used[i] = false;
      buffer[idx] = 0;
    }
    return ret;
  }

  public int countArrangement(int n) {

    return solve(n, 0, new int[n], new boolean[n + 1]);
  }
}

public class _526_Beautiful_Arrangement {
  public static void main(String[] args) {
    System.out.println(new Solution().countArrangement(3));
  }
}
