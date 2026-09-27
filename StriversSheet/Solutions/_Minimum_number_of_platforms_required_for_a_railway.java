import java.util.Arrays;
import java.util.Arrays;

class Solution {

  public int findPlatform(int[] arrival, int[] departure) {
    Arrays.sort(arrival);
    Arrays.sort(departure);

    int i = 0;
    int j = 0;

    int platforms = 0;
    int maxPlatforms = 0;

    while (i < arrival.length && j < departure.length) {
      if (arrival[i] <= departure[j]) {
        platforms++;
        maxPlatforms = Math.max(maxPlatforms, platforms);
        i++;
      } else {
        platforms--;
        j++;
      }
    }

    return maxPlatforms;
  }
}

public class _Minimum_number_of_platforms_required_for_a_railway {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findPlatform(
        new int[] { 800, 830, 900, 1000, 1030, 1100, 1500 },
        new int[] { 845, 930, 1030, 1130, 1200, 1300, 1600 }
      )
    );
  }
}
