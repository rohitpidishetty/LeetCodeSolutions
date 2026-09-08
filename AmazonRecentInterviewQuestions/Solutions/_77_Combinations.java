import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(
    List<Integer> buff,
    int start,
    int n,
    int k,
    List<List<Integer>> freq
  ) {
    if (start > n) {
      if (buff.size() == k) freq.add(new ArrayList<>(buff));
      return;
    }

    // skip
    solve(buff, start + 1, n, k, freq);

    // take
    buff.add(start);
    solve(buff, start + 1, n, k, freq);
    buff.remove(buff.size() - 1);
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> freq = new ArrayList<>();
    solve(new ArrayList<>(), 1, n, k, freq);
    return freq;
  }
}

public class _77_Combinations {

  public static void main(String[] args) {
    System.out.println(new Solution().combine(4, 2));
  }
}
