class Solution {

  public int bestRotation(int[] nums) {
    int n = nums.length;
    int[] diff = new int[n + 1];

    for (int i = 0; i < n; i++) {
      int low = (i + 1) % n;
      int high = (i - nums[i] + n) % n;

      diff[low]++;
      diff[high]--;

      if (low >= high) diff[0]++;
    }

    int maxScore = 0;
    int score = 0;
    int bestK = 0;

    for (int k = 0; k < n; k++) {
      score += diff[k];
      if (score > maxScore) {
        maxScore = score;
        bestK = k;
      }
    }

    return bestK;
  }
}

public class _798_Smallest_Rotation_with_Highest_Score {

  public static void main(String[] args) {
    System.out.println(
      new Solution().bestRotation(new int[] { 2, 3, 1, 4, 0 })
    );
  }
}
