import java.util.Arrays;

class Solution {

  // public boolean increasingTriplet(int[] nums) {
  //   int n = nums.length;
  //   int[] seqLen = new int[n];

  //   for (int i = 0; i < n; i++) {
  //     for (int j = 0; j < i; j++) {
  //       if (nums[i] > nums[j]) {
  //         seqLen[i] = Math.max(seqLen[i], seqLen[j] + 1);
  //         if (seqLen[i] + 1 >= 3) return true;
  //       }
  //     }
  //   }

  //   return false;
  // }

  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num <= first) first = num;
      else if (num <= second) second = num;
      else return true;
    }

    return false;
  }
}

public class _334_Increasing_Triplet_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 })
    );
  }
}
