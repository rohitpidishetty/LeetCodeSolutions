import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Solution {

  private int n;
  private Random rand;
  private int threshold;
  private Map<Integer, Integer> map;

  public Solution(int n, int[] blacklist) {
    // Map the blacklisted numbers with non-black listed nums.
    this.n = n;
    this.rand = new Random();
    this.map = new HashMap<>();
    int threshold = n - blacklist.length;
    this.threshold = threshold;
    Set<Integer> listed = new HashSet<>();
    for (int i : blacklist) listed.add(i);
    int x = n - 1;
    for (int i = 0; i < threshold; i++) {
      if (listed.contains(i)) {
        while (x >= threshold && listed.contains(x)) x--;
        this.map.put(i, x--);
      }
    }
  }

  public int pick() {
    int x = rand.nextInt(this.threshold);
    return this.map.getOrDefault(x, x);
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
public class _710_Random_Pick_with_Blacklist {

  public static void main(String[] args) {
    Solution obj = new Solution(7, new int[] { 2, 3, 5 });
    // 0,1,2,3,4,5,6,7 => 0,1,4,6
    System.out.println(obj.pick());
  }
}
