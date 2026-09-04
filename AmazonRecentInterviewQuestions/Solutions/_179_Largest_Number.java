import java.util.Arrays;

class Solution {

  public String largestNumber(int[] nums) {
    String[] numbers = new String[nums.length];
    for (int i = 0; i < nums.length; i++) numbers[i] = String.valueOf(nums[i]);
    Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
    if (numbers[0].equals("0")) return "0";
    StringBuilder largestNumber = new StringBuilder();
    for (int i = 0; i < nums.length; i++) largestNumber.append(numbers[i]);
    return largestNumber.toString();
  }
}

public class _179_Largest_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestNumber(new int[] { 3, 30, 34, 5, 9 })
    );
  }
}
