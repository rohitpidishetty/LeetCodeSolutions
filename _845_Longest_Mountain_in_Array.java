import java.util.Stack;

class Solution {

  public int longestMountain(int[] arr) {
    int top = arr[0];
    int max = Integer.MIN_VALUE;
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > top) count++;
      else count = 1;
      top = arr[i];
      int j = i + 1;
      int peek = top;
      while (count > 1 && j < arr.length && arr[j] < peek) {
        peek = arr[j];
        j++;
      }
      if (j > i + 1) max = Math.max(j - 1 - i + count, max);
    }
    return max == Integer.MIN_VALUE ? 0 : max == 1 ? 0 : max;
  }
}

public class _845_Longest_Mountain_in_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 })
    );

    System.out.println(new Solution().longestMountain(new int[] { 2, 2, 2 }));
  }
}
