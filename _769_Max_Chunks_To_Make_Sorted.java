class Solution {

  public int maxChunksToSorted(int[] arr) {
    int n = arr.length;
    int[] minTowardsRight = new int[n];
    int min = arr[n - 1];
    minTowardsRight[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] < min) min = arr[i];
      minTowardsRight[i] = min;
    }
    int chunks = 1;
    int leftMax = arr[0];
    for (int i = 0; i < n; i++) {
      leftMax = Math.max(leftMax, arr[i]);
      if (leftMax >= minTowardsRight[i]) chunks++;
    }
    return chunks;
  }
}

public class _769_Max_Chunks_To_Make_Sorted {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxChunksToSorted(new int[] { 4, 3, 2, 1, 0 })
    );
  }
}
