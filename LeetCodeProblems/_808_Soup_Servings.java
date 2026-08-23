import java.util.LinkedHashMap;
import java.util.Map;

class Solution {

  private Map<String, Double> memo;

  private double solve(int n, int m) {
    String key = n + "," + m;
    if (this.memo.containsKey(key)) return this.memo.get(key);
    if (n <= 0 && m <= 0) return 0.5d;
    if (n <= 0) return 1.0d;
    if (m <= 0) return 0.0d;
    double res = ((solve(n - 100, m - 0) +
        solve(n - 25, m - 75) +
        solve(n - 50, m - 50) +
        solve(n - 75, m - 25)) *
      0.25d);

    this.memo.put(key, res);
    return res;
  }

  public double soupServings(int n) {
    if (n > 4800) return 1.0;
    this.memo = new LinkedHashMap<>(16, 1.7f, true);
    return solve(n, n);
  }
}

public class _808_Soup_Servings {

  public static void main(String[] args) {
    System.out.println(new Solution().soupServings(660295675));
  }
}
