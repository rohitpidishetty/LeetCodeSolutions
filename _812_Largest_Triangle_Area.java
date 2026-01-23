class Solution {

  public double largestTriangleArea(int[][] points) {
    double area = 0.0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          area = Math.max(area, area(points[i], points[j], points[k]));
        }
      }
    }
    return area;
  }

  private double area(int[] a, int[] b, int[] c) {
    double[] ab = new double[] { (b[0] - a[0]), (b[1] - a[1]) };
    double[] ac = new double[] { (c[0] - a[0]), (c[1] - a[1]) };
    return Math.abs(ab[0] * ac[1] - ab[1] * ac[0]) / 2.0;
  }
}

public class _812_Largest_Triangle_Area {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestTriangleArea(
        new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } }
      )
    );
  }
}
