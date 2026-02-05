class Solution {

  public double new21Game(int n, int k, int maxPts) {
    if (k == 0 || (n >= k - 1 + maxPts)) return 1.0;
    // for (int i = n; i >= k; i--) {
    //   System.out.print("P(" + i + ") = ");
    //   for (int j = Math.max(0, i - maxPts); j < k && j < i; j++) {
    //     System.out.print("P(" + j + ") + ");
    //   }
    //   System.out.print(" / " + (1 / (float) maxPts));
    //   System.out.println();
    // }
    double P[] = new double[n + 1];
    P[0] = 1.0;
    double soFarSum = 1.0;

    for (int i = 1; i <= n; i++) {
      P[i] = soFarSum / (float) maxPts;
      if (i < k) soFarSum += P[i];
      if (i - maxPts >= 0) soFarSum -= P[i - maxPts];
    }
    double result = 0.0;
    for (int i = k; i <= n; i++) result += P[i];
    return result;
  }
}

public class _837_New_21_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().new21Game(21, 17, 10));
    System.out.println(new Solution().new21Game(6, 1, 10));
  }
}
