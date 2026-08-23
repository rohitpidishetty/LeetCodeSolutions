class Solution {

  public boolean xorGame(int[] nums) {
    int xor = 0;
    for (int x : nums) xor ^= x;
    return xor == 0 || nums.length % 2 == 0;
  }
}

public class _810_Chalkboard_XOR_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().xorGame(new int[] { 1, 1, 2 }));
  }
}
