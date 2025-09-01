import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private int[] sol_buff;

  private int[] merge(int[] left, int[] right, int[] buffer, int[] payload) {
    int[] temp = new int[left.length + right.length];
    int idx = 0;
    int i = 0;
    int j = 0;
    while (i < left.length && j < right.length) {
      if (payload[left[i]] > payload[right[j]]) {
        sol_buff[left[i]] += right.length - j;

        temp[idx++] = left[i++];
      } else temp[idx++] = right[j++];
    }
    while (i < left.length) temp[idx++] = left[i++];
    while (j < right.length) temp[idx++] = right[j++];
    return temp;
  }

  private int[] binarySegmentation(
    int left,
    int right,
    int[] ibt_buffer,
    int[] payload
  ) {
    if (left == right) return new int[] { left };
    int mid = (left + right) / 2;
    int[] l_arr = binarySegmentation(left, mid, ibt_buffer, payload);
    int[] r_arr = binarySegmentation(mid + 1, right, ibt_buffer, payload);
    return merge(l_arr, r_arr, ibt_buffer, payload);
  }

  public List<Integer> countSmaller(int[] nums) {
    int size = nums.length;
    int[] indexedBinaryTree = new int[size];
    sol_buff = new int[size];
    for (int i = 0; i < size; i++) indexedBinaryTree[i] = i;
    nums = binarySegmentation(0, size - 1, indexedBinaryTree, nums);
    List<Integer> buff = new ArrayList<>();
    for (int a : sol_buff) buff.add(a);
    return buff;
  }
}

public class _315_Count_of_Smaller_Numbers_After_Self {

  public static void main(String[] args) {
    System.out.println(
      new Solution().countSmaller(new int[] { 3, 4, 9, 6, 1 })
    );
  }
}
