import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  /**
   * 
   * 27 / 77 testcases passed
   * private int max;
   * private void dfs(int s, String[] buffer, ArrayList<String> set, int zc, int
   * oc, int zcl, int ocl) {
   * if (zc > zcl || oc > ocl)
   * return;
   * max = Math.max(max, set.size());
   * for (int i = s; i < buffer.length; i++) {
   * int n = buffer[i].length();
   * int zcs = 0, ocs = 0;
   * 
   * for (int j = 0; j < n; j++) {
   * if (buffer[i].charAt(j) == '0')
   * zcs++;
   * else if (buffer[i].charAt(j) == '1')
   * ocs++;
   * }
   * if (zc + zcs > zcl || oc + ocs > ocl)
   * continue;
   * set.add(buffer[i]);
   * dfs(i + 1, buffer, set, zc + zcs, oc + ocs, zcl, ocl);
   * set.remove(set.size() - 1);
   * }
   * }
   * 
   * public int findMaxForm(String[] strs, int m, int n) {
   * int zero_count = 0, one_count = 0;
   * max = 0;
   * dfs(0, strs, new ArrayList<>(), zero_count, one_count, m, n);
   * return max;
   * }
   * 
   */

  // Skip & Take

  private String[] buff;
  private Integer[][][] memo;
  private int zl = 0, ol = 0;

  private int solve(List<String> set, int idx, int czc, int coc) {

    if (idx >= this.buff.length)
      return 0;

    if (memo[idx][czc][coc] != null)
      return memo[idx][czc][coc];

    int skip = solve(set, idx + 1, czc, coc);

    int zs = 0;
    int os = 0;

    for (char ch : this.buff[idx].toCharArray()) {
      if (ch == '0')
        zs++;
      else
        os++;
    }

    int take = 0;

    if (czc + zs <= this.zl && coc + os <= this.ol)
      take = 1 + solve(set, idx + 1, czc + zs, coc + os);
    memo[idx][czc][coc] = Math.max(skip, take);
    return memo[idx][czc][coc];
  }

  public int findMaxForm(String[] strs, int m, int n) {
    memo = new Integer[strs.length + 1][m + 1][n + 1];
    this.buff = strs;
    this.zl = m;
    this.ol = n;
    int curr_zeros_count = 0;
    int curr_ones_count = 0;
    return solve(new ArrayList<>(), 0, curr_zeros_count, curr_ones_count);
  }
}

public class _474_Ones_and_Zeroes {
  public static void main(String[] args) {
    System.out
        .println(
            new Solution()
                .findMaxForm(
                    new String[] { "10", "0001", "111001", "1", "0" },
                    5, 3));
  }
}
