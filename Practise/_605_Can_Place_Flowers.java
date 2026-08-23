// class Solution {

//   // 115/130 passed
//   private Boolean[][][] memo;

//   private boolean solve(int prev, int idx, int[] buffer, int limit) {
//     if (idx >= buffer.length) return limit <= 0;
//     if (buffer[idx] == prev && prev == 1) return false;
//     if (limit <= 0) return true;

//     if (this.memo[prev][idx][limit] != null) return this.memo[prev][idx][limit];
//     // skip
//     boolean skip = solve(buffer[idx], idx + 1, buffer, limit);
//     if (skip) return true;
//     // take
//     boolean take = false;
//     int next = (idx + 1 < buffer.length ? buffer[idx + 1] : 0);
//     if (buffer[idx] == 0 && prev == 0 && next == 0) {
//       buffer[idx] = 1;
//       take = solve(buffer[idx], idx + 1, buffer, limit - 1);
//       if (take) return true;
//       buffer[idx] = 0;
//     }

//     return this.memo[prev][idx][limit] = (skip || take);
//   }

//   public boolean canPlaceFlowers(int[] flowerbed, int n) {
//     this.memo = new Boolean[2][flowerbed.length][n + 1];
//     int prev_bit, current_index;
//     return solve(prev_bit = 0, current_index = 0, flowerbed, n);
//   }
// }

// public class _605_Can_Place_Flowers {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 0, 1 }, 2)
//     );
//   }
// }

class Solution {

  private boolean[][][] memo;
  private boolean[][][] seen;

  private boolean solve(int prev, int idx, int[] buffer, int limit) {
    if (idx >= buffer.length) return limit <= 0;
    if (buffer[idx] == prev && prev == 1) return false;
    if (limit <= 0) return true;

    if (seen[prev][idx][limit]) return memo[prev][idx][limit];
    seen[prev][idx][limit] = true;

    boolean skip = solve(buffer[idx], idx + 1, buffer, limit);
    if (skip) return memo[prev][idx][limit] = true;

    boolean take = false;
    int next = (idx + 1 < buffer.length ? buffer[idx + 1] : 0);
    if (buffer[idx] == 0 && prev == 0 && next == 0) {
      buffer[idx] = 1;
      take = solve(1, idx + 1, buffer, limit - 1);
      buffer[idx] = 0;
    }

    return memo[prev][idx][limit] = (skip || take);
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int len = flowerbed.length;
    memo = new boolean[2][len][Math.min(n + 1, len + 1)];
    seen = new boolean[2][len][Math.min(n + 1, len + 1)];
    return solve(0, 0, flowerbed, n);
  }
}

public class _605_Can_Place_Flowers {

  public static void main(String[] args) {
    System.out.println(
      new Solution().canPlaceFlowers(new int[] { 1, 0, 0, 0, 0, 1 }, 2)
    );
  }
}
