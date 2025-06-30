import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int size = nums.length - 1;
    int limit = size - 2;
    int idx = 0;
    int nearestSum = nums[idx] + nums[idx + 1] + nums[idx + 2];
    while (idx <= limit) {
      int leftPointer = idx + 1;
      int rightPointer = size;
      while (leftPointer < rightPointer) {
        int currentSum = nums[idx] + nums[leftPointer] + nums[rightPointer];
        if (Math.abs(target - currentSum) < Math.abs(target - nearestSum))
          nearestSum = currentSum;

        if (currentSum < target)
          leftPointer++;
        else if (currentSum > target)
          rightPointer--;
        else
          return currentSum;
      }
      idx++;
    }
    return nearestSum;
  }
}

public class _16_3sum {
  public static void main(String[] args) {
    System.out.println(new Solution().threeSumClosest(new int[] { 0, 1, 2 }, 3));
  }
}