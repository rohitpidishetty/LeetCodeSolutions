import java.util.Arrays;

class NumArray {

  // Version 0: 15/16 (Passed), 1 TLE
  // private int[] buffer;
  // private int[] payload;

  // public NumArray(int[] nums) {
  //   buffer = new int[nums.length];
  //   payload = nums;
  //   buffer[0] = nums[0];
  //   for (int i = 1; i < nums.length; i++) buffer[i] = buffer[i - 1] + nums[i];
  // }

  // public void update(int index, int val) {
  //   int valueAtIndex = payload[index];
  //   int bar = 0;
  //   bar = val - valueAtIndex;

  //   payload[index] = val;
  //   for (int i = index; i < buffer.length; i++) buffer[i] += bar;
  // }

  // public int sumRange(int left, int right) {
  //   if (left <= right && left >= 0 && right < buffer.length) return left == 0
  //     ? buffer[right]
  //     : buffer[right] - buffer[left - 1];
  //   return 0;
  // }

  private int[] buffer;
  private int[] array;

  private void buildSegmentTree(int left, int right, int index) {
    if (left == right) {
      buffer[index] = array[left];
      return;
    }
    int mid = (left + right) / 2;
    int leftIdx = (2 * index) + 1;
    int rightIdx = (2 * index) + 2;
    buildSegmentTree(left, mid, leftIdx);
    buildSegmentTree(mid + 1, right, rightIdx);
    buffer[index] = buffer[leftIdx] + buffer[rightIdx];
  }

  public NumArray(int[] nums) {
    buffer = new int[nums.length * 4];
    array = nums;
    buildSegmentTree(0, nums.length - 1, 0);
  }

  private void updateSegmentTree(
    int left,
    int right,
    int index,
    int value,
    int i
  ) {
    if (left == right) {
      buffer[i] = value;
      return;
    }
    int mid = (left + right) / 2;

    if (index <= mid) updateSegmentTree(left, mid, index, value, 2 * i + 1);
    else if (index > mid) updateSegmentTree(
      mid + 1,
      right,
      index,
      value,
      2 * i + 2
    );

    int leftIdx = (2 * i) + 1;
    int rightIdx = (2 * i) + 2;

    buffer[i] = buffer[leftIdx] + buffer[rightIdx];
  }

  public void update(int index, int val) {
    int left = 0;
    int right = array.length - 1;
    int setIndex = 0;
    array[index] = val;
    updateSegmentTree(left, right, index, val, setIndex);
  }

  private int fetchFromTree(int l, int r, int l_range, int r_range, int idx) {
    if (l > r_range || l_range > r) return 0;
    if (l <= l_range && r_range <= r) return buffer[idx];
    int m = (l_range + r_range) / 2;

    int leftSum = fetchFromTree(l, r, l_range, m, 2 * idx + 1);
    int rightSum = fetchFromTree(l, r, m + 1, r_range, 2 * idx + 2);

    return leftSum + rightSum;
  }

  public int sumRange(int left, int right) {
    return fetchFromTree(left, right, 0, array.length - 1, 0);
  }
}

public class _307_Range_Sum_Query_Mutable {

  public static void main(String[] args) {
    NumArray obj = new NumArray(new int[] { 1, 2, 4, 7, 8 });
    obj.update(2, 6);
  }
}
