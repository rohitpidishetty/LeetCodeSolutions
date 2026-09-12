class Solution {

  public double[] convertTemperature(double celsius) {
    return new double[] { celsius + 273.15d, celsius * 1.80d + 32.00d };
  }
}

public class _2469_Convert_the_Temperature {

  public static void main(String[] args) {
    System.out.println(new Solution().convertTemperature(36.50));
  }
}
