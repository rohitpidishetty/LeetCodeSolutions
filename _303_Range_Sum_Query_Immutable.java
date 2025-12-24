class NumArray {

  private int buffer[];

  public NumArray(int[] nums) {
    buffer = new int[nums.length];
    int currentSum = nums[0];
    buffer[0] = currentSum;
    for (int i = 1; i < nums.length; i++) buffer[i] = nums[i] + buffer[i - 1];
  }

  public int sumRange(int left, int right) {
    if (left <= right && left >= 0 && right < buffer.length) return left == 0
      ? buffer[right]
      : buffer[right] - buffer[left - 1];
    return 0;
  }
}

public class _303_Range_Sum_Query_Immutable {

  public static void main(String[] args) {
    NumArray obj = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });

    System.out.println(obj.sumRange(0, 5));
  }
}
