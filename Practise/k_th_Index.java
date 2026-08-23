import java.util.ArrayList;
import java.util.List;

class Solution {
  private String solve(String res, List<Integer> numberBucket, List<Integer> factorialBucket, int k, int n) {
    if (n == 1) {
      res += numberBucket.getLast();
      return res;
    }
    int blockSize = factorialBucket.get(n - 1);
    int blockIndex = k / blockSize;
    if (k % blockSize == 0)
      blockIndex -= 1;
    res += numberBucket.get(blockIndex);
    numberBucket.remove(blockIndex);
    k -= (blockSize * blockIndex);
    return solve(res, numberBucket, factorialBucket, k, n - 1);
  }

  public String getPermutation(int n, int k) {
    List<Integer> numberBucket = new ArrayList<>();
    for (int i = 1; i <= n; i++)
      numberBucket.add(i);
    List<Integer> factorialBucket = new ArrayList<>();
    int factorial = 1;
    factorialBucket.add(factorial);
    for (int i = 1; i <= n; i++) {
      factorial *= i;
      factorialBucket.add(factorial);
    }
    return this.solve(new String(), numberBucket, factorialBucket, k, n);
  }
}

// public class k_th_Index {
//   public static void main(String[] args) {
//     System.out.println(new Solution().getPermutation(4, 14));
//   }
// }
