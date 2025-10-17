// import java.util.Arrays;

// class Solution {
//   public int[] constructRectangle(int area) {
//     int[] factors = new int[2];
//     int min = Integer.MAX_VALUE;
//     for (int i = area; i > 0; i--) {
//       if (area % i == 0) {
//         if ((area / i) > i)
//           break;
//         int diff = (i - (area / i));
//         if (diff < min) {
//           min = diff;
//           factors[0] = i;
//           factors[1] = (area / i);
//         }
//       }
//     }
//     return factors;
//   }
// }

// public class _492_Construct_the_Rectangle {
//   public static void main(String[] args) {
//     System.out.println(Arrays.toString(new Solution().constructRectangle(122122)));
//   }
// }
import java.util.Arrays;

class Solution {
  public int[] constructRectangle(int area) {
    int[] factors = new int[2];
    int min = Integer.MAX_VALUE;

    for (int i = (int) Math.sqrt(area); i > 0; i--) {
      if (area % i == 0) {
        factors[0] = area / i;
        factors[1] = i;
        return factors;
      }
    }
    return factors;
  }
}

public class _492_Construct_the_Rectangle {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().constructRectangle(122122)));
  }
}
