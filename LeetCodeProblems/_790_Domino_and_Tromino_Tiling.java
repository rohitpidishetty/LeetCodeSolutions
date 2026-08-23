class Solution {

  private Integer N[] = new Integer[1001];

  public int numTilings(int n) {
    int mod = 1_000_000_007;
    if (n == 1 || n == 2) return n;
    if (n == 3) return 5;
    if (N[n] != null) return N[n];
    return N[n] =
      (((2 * numTilings(n - 1)) % mod) + (numTilings(n - 3) % mod)) % mod;
  }
}

public class _790_Domino_and_Tromino_Tiling {

  public static void main(String[] args) {
    System.out.println(new Solution().numTilings(3));
  }
}
