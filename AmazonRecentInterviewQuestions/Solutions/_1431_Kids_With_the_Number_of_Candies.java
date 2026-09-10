import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int n = candies.length;
    int max = 0;
    for (int i = 0; i < n; i++) max = Math.max(max, candies[i]);
    List<Boolean> res = new ArrayList<>();
    for (int i = 0; i < n; i++) res.add(candies[i] + extraCandies >= max);
    return res;
  }
}

public class _1431_Kids_With_the_Number_of_Candies {

  public static void main(String[] args) {
    System.out.println(
      new Solution().kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3)
    );
  }
}
