import java.util.Arrays;

class Solution {

  public int trap(int[] height) {
    if(height.length == 0) return 0;
    int lm[] = new int[height.length];
    int rm[] = new int[height.length];
    int lmx = Integer.MIN_VALUE;
    int rmx = Integer.MIN_VALUE;
    for (int i = 0; i < height.length; i++) lmx =
      lm[i] = Math.max(lmx, height[i]);
    for (int i = height.length - 1; i >= 0; i--) rmx =
      rm[i] = Math.max(rmx, height[i]);
    int ans = 0;
    for (int i = 0; i < height.length; i++) ans +=
      Math.min(lm[i], rm[i]) - height[i];
    return ans;
  }
}

public class _42 {

  public static void main(String[] args) {
    System.out.println(new Solution().trap(new int[] { 4, 2, 0, 3, 2, 5 }));
  }
}
