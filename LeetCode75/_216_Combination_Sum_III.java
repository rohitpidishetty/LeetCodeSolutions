import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    int k,
    int n,
    int num,
    List<Integer> buff,
    int sum,
    List<List<Integer>> res
  ) {
    if (num > 10) return;
    if (buff.size() == k && sum == n) {
      res.add(new ArrayList<>(buff));
      return;
    }

    // skip
    solve(k, n, num + 1, buff, sum, res);

    // take
    buff.add(num);
    solve(k, n, num + 1, buff, sum + num, res);
    buff.remove(buff.size() - 1);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    solve(k, n, 1, new ArrayList<>(), 0, res);
    return res;
  }
}

public class _216_Combination_Sum_III {

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum3(3, 9));
  }
}
