import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class Solution {

  public int maxSumSubmatrix(int[][] matrix, int k) {
    int leftPointer = 0;
    int rightPointer = 0;
    int[] buffer = new int[matrix.length];

    int max = Integer.MIN_VALUE;
    while (leftPointer < matrix[0].length) {
      while (rightPointer < matrix[0].length) {
        int i = 0;
        while (i < buffer.length) buffer[i] += matrix[i++][rightPointer];
        // int res = kadaensAlgoMaxSubArraySum(buffer);
        // max = Math.max(max, res);
        // Find the max subarray sum <= k for this buffer
        int curMax = maxSubArrayNoLargerThanK(buffer, k);
        max = Math.max(max, curMax);
        if (max == k) return k; // Early exit
        rightPointer++;
      }
      Arrays.fill(buffer, 0);
      leftPointer++;
      rightPointer = leftPointer;
    }

    return max;
  }

  private int maxSubArrayNoLargerThanK(int[] arr, int k) {
    int sum = 0;
    int max = Integer.MIN_VALUE;

    TreeSet<Integer> prefixSums = new TreeSet<>();
    prefixSums.add(0);
    for (int num : arr) {
      sum += num;
      // sum - currentSum <= k
      // sum - k <= currentSum
      // Let t = ceil(sum - k)
      Integer target = prefixSums.ceiling(sum - k);
      if (target != null) {
        int currSum = sum - target;
        max = Math.max(max, currSum);
      }
      prefixSums.add(sum);
    }

    return max;
  }

  private int kadaensAlgoMaxSubArraySum(int[] buffer) {
    int max = Integer.MIN_VALUE;
    int i = 0;
    int currentMax = 0;
    int n = buffer.length;
    while (i < n) {
      if (currentMax + buffer[i] < buffer[i]) currentMax = buffer[i];
      else currentMax += buffer[i];
      max = Math.max(max, currentMax);
      i++;
    }
    return max;
  }
}

public class _363_Max_Sum_of_Rectangle_No_Larger_Than_K {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxSumSubmatrix(new int[][] { { 1, 0, 1 }, { 0, -2, 3 } }, 2)
    );
  }
}
