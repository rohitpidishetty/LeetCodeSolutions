import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Solution {

  private Set<Integer> usedIndicies = new HashSet<>();
  private Random rand;
  private int total, M, N;

  public Solution(int m, int n) {
    this.rand = new Random();
    this.total = m * n;
    this.M = m;
    this.N = n;
  }

  public int[] flip() {
    if (usedIndicies.size() == total)
      return new int[] { -1, -1 };
    int index = this.rand.nextInt(this.total);
    while (this.usedIndicies.contains(index))
      index = this.rand.nextInt(this.total);
    this.usedIndicies.add(index);

    return new int[] { index / this.N, index % this.N };
  }

  public void reset() {
    this.usedIndicies.clear();
  }
}

public class _519_Random_Flip_Matrix {
  public static void main(String[] args) {
    int m, n;
    Solution obj = new Solution(m = 3, n = 1);
    int[] param_1 = obj.flip();
    System.out.println(Arrays.toString(param_1));
    System.out.println(Arrays.toString(obj.flip()));
    System.out.println(Arrays.toString(obj.flip()));
    System.out.println(Arrays.toString(obj.flip()));
    obj.reset();
  }
}
