import java.util.Arrays;

class Solution {

  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int h = numbers.length - 1;
    while (l < h) {
      int sum = numbers[l] + numbers[h];
      if (sum == target) break;
      else if (sum > target) h--;
      else l++;
    }
    return new int[] { l + 1, h + 1 };
  }
}

public class _167_Two_Sum_II_Input_Array_Is_Sorted {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9))
    );
  }
}
