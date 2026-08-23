import java.util.Arrays;
import java.util.Random;

class Solution {

  private double x_ = 0, y_ = 0, r = 0;
  private Random random;

  public Solution(double radius, double x_center, double y_center) {
    this.x_ = x_center;
    this.y_ = y_center;
    this.r = radius;
    this.random = new Random();
  }

  public double[] randPoint() {
    double theta = 2 * Math.PI * random.nextDouble();
    double inBoundRadius = r * Math.sqrt(random.nextDouble());
    return new double[] { x_ + (inBoundRadius * Math.cos(theta)), y_ + (inBoundRadius * Math.sin(theta)) };
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
public class _478_Generate_Random_Point_in_a_Circle {
  public static void main(String[] args) {
    Solution obj = new Solution(1.0, 0, 0);
    System.out.println(Arrays.toString(obj.randPoint()));
  }
}
