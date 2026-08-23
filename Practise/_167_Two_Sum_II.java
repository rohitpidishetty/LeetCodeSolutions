import java.util.Arrays;

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] == target)
        return new int[] { i + 1, j + 1 };
      else if (numbers[i] + numbers[j] > target)
        j--;
      else
        i++;
    }
    return null;
  }
}

public class _167_Two_Sum_II {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().twoSum(new int[] { 3, 24, 50, 79, 88, 150, 345 }, 200)));
  }
}
