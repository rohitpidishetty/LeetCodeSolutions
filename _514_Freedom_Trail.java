import java.util.*;

class Solution {

  private Integer[][] memo;

  private int solve(String ring, String key, int key_idx, int ring_idx, int n, int m) {
    if (memo[ring_idx][key_idx] != null)
      return memo[ring_idx][key_idx];
    if (key_idx == m)
      return 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++)
      if (ring.charAt(i) == key.charAt(key_idx))
        min = Math.min(min, (rotateTo12(ring_idx, i, n) + pressButton() + solve(ring, key, key_idx + 1, i, n, m)));
    memo[ring_idx][key_idx] = min;
    return min;
  }

  private int rotateTo12(int dial_main_idx, int char_found_at, int total_len) {
    int anti_clock = Math.abs(dial_main_idx - char_found_at);
    int clock_wise = total_len - anti_clock;
    return Math.min(anti_clock, clock_wise);
  }

  private int pressButton() {
    return 1;
  }

  public int findRotateSteps(String ring, String key) {
    this.memo = new Integer[101][101];
    int total_len = ring.length(), key_len = key.length(), key_idx = 0, ring_idx = 0;
    return solve(ring, key, key_idx, ring_idx, total_len, key_len);
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findRotateSteps("godding", "gd"));
  }
}
