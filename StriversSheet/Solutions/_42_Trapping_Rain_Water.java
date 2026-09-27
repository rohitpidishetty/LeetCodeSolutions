import java.util.Arrays;

class Solution {

  public int trap(int[] height) {
    int n = height.length;
    int buffer[] = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) max = buffer[i] = Math.max(max, height[i]);
    max = 0;
    for (int i = n - 1; i >= 0; i--) {
      max = buffer[i] = Math.min(buffer[i], Math.max(height[i], max));
    }
    int result = 0;
    for (int i = 0; i < n; i++) result += Math.abs(height[i] - buffer[i]);
    return result;
  }
}

public class _42_Trapping_Rain_Water {

  public static void main(String[] args) {
    System.out.println(
      new Solution().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 })
    );
  }
}
