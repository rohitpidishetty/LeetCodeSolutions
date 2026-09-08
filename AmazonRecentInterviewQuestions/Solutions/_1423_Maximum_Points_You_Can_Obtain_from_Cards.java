import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

  // Recursive solution.
  // private int solve(
  //   int[] weights,
  //   int k,
  //   int i,
  //   int j,
  //   Map<String, Integer> memo
  // ) {
  //   if (k == 0 || i > j) return 0;
  //   String key = i + "," + j;
  //   if (memo.containsKey(key)) return memo.get(key);
  //   int max = Math.max(
  //     weights[i] + solve(weights, k - 1, i + 1, j, memo),
  //     weights[j] + solve(weights, k - 1, i, j - 1, memo)
  //   );
  //   memo.put(key, max);
  //   return max;
  // }
  // public int maxScore(int[] cardPoints, int k) {
  //   Map<String, Integer> memo = new HashMap<>();
  //   return solve(cardPoints, k, 0, cardPoints.length - 1, memo);
  // }

  public int maxScore(int[] cardPoints, int k) {
    int max = 0;
    int leftSum = 0;
    int rightSum = 0;
    for (int i = 0; i < k; i++) leftSum += cardPoints[i];
    max = leftSum;
    int n = cardPoints.length;
    int m = k - 1;
    for (int i = n - 1; i >= n - k; i--) {
      // System.out.println(i + " " + m);
      leftSum -= cardPoints[m];
      leftSum += cardPoints[i];
      max = Math.max(max, leftSum);
      m--;
    }
    return max;
  }
}

public class _1423_Maximum_Points_You_Can_Obtain_from_Cards {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxScore(new int[] { 9, 7, 7, 9, 7, 7, 9 }, 4)
    );
  }
}
