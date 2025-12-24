import java.util.Arrays;
import java.util.Random;

class Solution {

  private int[] prefix;
  private Random rand;
  private int lim;

  public Solution(int[] w) {
    this.prefix = new int[w.length];
    this.rand = new Random();
    this.prefix[0] = w[0];
    for (int i = 1; i < w.length; i++)
      this.prefix[i] = this.prefix[i - 1] + w[i];
    this.lim = prefix[prefix.length - 1];
  }

  public int pickIndex() {
    int limit = this.rand.nextInt(lim) + 1;
    int i = 0, j = this.prefix.length - 1;
    while (i <= j) {
      int m = (i + j) / 2;
      if (this.prefix[m] >= limit)
        j = m - 1;
      else
        i = m + 1;
    }
    return i;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

public class _528_Random_Pick_with_Weight {
  public static void main(String[] args) {

    Solution obj = new Solution(new int[] { 1, 2 });
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
    System.out.println(obj.pickIndex());
  }
}