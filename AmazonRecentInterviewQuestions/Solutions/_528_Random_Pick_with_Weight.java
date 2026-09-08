import java.util.Random;

class Solution {

  private int[] prefixSum;
  private Random rand;

  public Solution(int[] w) {
    rand = new Random();
    prefixSum = new int[w.length];
    prefixSum[0] = w[0];
    for (int i = 1; i < prefixSum.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + w[i];
    }
  }

  public int pickIndex() {
    int n = prefixSum.length;
    int target = rand.nextInt(prefixSum[n - 1]) + 1;
    int l = 0;
    int h = n - 1;
    while (l <= h) {
      int m = (l + (h - l) / 2);
      if (target <= prefixSum[m]) h = m - 1;
      else l = m + 1;
    }
    return l;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
public class _528_Random_Pick_with_Weight {

  public static void main(String[] args) {
    Solution s = new Solution(new int[] { 2, 5, 1, 3, 4 });
  }
}
