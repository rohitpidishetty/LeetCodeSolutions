import java.util.List;
import java.util.ArrayList;

class Solution {
  private void rec(int s, int n, int k, ArrayList<Integer> x, List<List<Integer>> l) {
    if (x.size() == k){
      l.add(new ArrayList<>(x));
      return ;
    }
    for (int i = s; i <= n; i++) {
      x.add(i);
      rec(i + 1, n, k, x, l);
      x.removeLast();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> l = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      rec(i, n, k, new ArrayList<>(), l);
    return l;
  }
}

public class BackTrack {
  public static void main(String[] args) {
    System.out.println(new Solution().combine(1, 1));
  }
}