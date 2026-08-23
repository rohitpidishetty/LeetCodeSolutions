import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

class Solution {

  private int[] take_n_elements_from_buffer(
    int consideration_size,
    int[] buffer
  ) {
    int actual_length_of_buffer = buffer.length;
    int number_of_elements_that_can_be_neglected =
      actual_length_of_buffer - consideration_size;
    Stack<Integer> S = new Stack<>();
    for (int buff_ele : buffer) {
      while (
        !S.isEmpty() &&
        S.peek() < buff_ele &&
        number_of_elements_that_can_be_neglected-- > 0
      ) S.pop();
      S.push(buff_ele);
    }
    while (S.size() > consideration_size) S.pop();
    int[] result = new int[consideration_size];
    int index = consideration_size - 1;
    while (!S.isEmpty()) result[index--] = S.pop();
    return result;
  }

  private boolean isGreater(int[] l_buff, int l_ptr, int[] r_buff, int r_ptr) {
    while (
      l_ptr < l_buff.length &&
      r_ptr < r_buff.length &&
      l_buff[l_ptr] == r_buff[r_ptr]
    ) {
      l_ptr++;
      r_ptr++;
    }
    if (r_ptr == r_buff.length) return true;
    if (l_ptr == l_buff.length) return false;
    return l_buff[l_ptr] > r_buff[r_ptr];
  }

  private int[] merge(int[] l_buff, int[] r_buff, int magnitude) {
    if (l_buff.length == 0) return r_buff;
    int[] result = new int[magnitude];
    int idx = 0;
    int l_ptr = 0;
    int r_ptr = 0;
    for (; idx < magnitude;) {
      if (isGreater(l_buff, l_ptr, r_buff, r_ptr)) result[idx++] =
        l_buff[l_ptr++];
      else result[idx++] = r_buff[r_ptr++];
    }

    return result;
  }

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] max = { 0, 0 };
    for (
      int i = Math.max(0, k - nums1.length);
      i <= Math.min(k, nums2.length);
      i++
    ) {
      int[] l_buff = take_n_elements_from_buffer(i, nums1);
      int[] r_buff = take_n_elements_from_buffer(k - i, nums2);
      int[] merged_buffer = merge(l_buff, r_buff, k);
      if (isGreater(merged_buffer, 0, max, 0)) {
        max = merged_buffer;
      }
    }
    return max;
  }
}

public class _321_Create_Maximum_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 5)
    );
  }
}
