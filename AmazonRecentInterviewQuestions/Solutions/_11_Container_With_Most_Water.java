class Solution {

  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int max = 0;
    while (i < j) max = Math.max(
      max,
      ((height[i] < height[j]) ? height[i++] : height[j--]) * (j - i)
    );
    return max;
  }
}

public class _11_Container_With_Most_Water {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })
    );
  }
}
