import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class NumArray {

  private int[] rangeSum;

  public NumArray(int[] nums) {
    int n = nums.length;
    int[] pre = new int[n];
    pre[0] = nums[0];
    for (int i = 1; i < n; i++) pre[i] = nums[i] + pre[i - 1];
    rangeSum = new int[n];
    for (int i = 0; i < n; i++) rangeSum[i] = pre[i];
  }

  public int sumRange(int left, int right) {
    return rangeSum[right] - ((left - 1) < 0 ? 0 : rangeSum[left - 1]);
  }
}

public class _303_Range_Sum_Query_Immutable {

  public static void main(String[] args) {
    NumArray num = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
    System.out.println(num.sumRange(0, 2));
    System.out.println(num.sumRange(2, 5));
    System.out.println(num.sumRange(0, 5));
  }
}
