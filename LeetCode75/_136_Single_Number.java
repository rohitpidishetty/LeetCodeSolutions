class Solution {

  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int num : nums) ans ^= num;
    return ans;
  }
}

public class _136_Single_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution().singleNumber(new int[] { 4, 1, 2, 1, 2 })
    );
  }
}
