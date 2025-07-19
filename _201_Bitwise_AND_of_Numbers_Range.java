class Solution {
  public int rangeBitwiseAnd(int left, int right) {
    // long ret = 0;
    // for (int i = left; i <= right; i++) {
    //   ret &= i;
    // }
    // return (int) ret;

    // Remove set bits from left.
    while (right > left)
      right = (right & (right - 1));
    return right;
  }
}
