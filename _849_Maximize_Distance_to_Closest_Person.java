import java.util.Arrays;

class Solution {

  public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int[] leftClosest = new int[n];
    int[] rightClosest = new int[n];
    for (int i = 0; i < n; i++) leftClosest[i] = (seats[i] == 1)
      ? i
      : i == 0
        ? Integer.MAX_VALUE
        : leftClosest[i - 1];

    for (int i = n - 1; i >= 0; i--) rightClosest[i] = (seats[i] == 1)
      ? i
      : i == n - 1
        ? Integer.MAX_VALUE
        : rightClosest[i + 1];

    int MAX = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int leftDist = (leftClosest[i] == Integer.MAX_VALUE)
        ? Integer.MAX_VALUE
        : i - leftClosest[i];
      int rightDist = (rightClosest[i] == Integer.MAX_VALUE)
        ? Integer.MAX_VALUE
        : rightClosest[i] - i;
      MAX = Math.max(MAX, Math.min(leftDist, rightDist));
    }

    return MAX;
  }
}

public class _849_Maximize_Distance_to_Closest_Person {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 })
    );
    System.out.println(
      new Solution().maxDistToClosest(new int[] { 1, 0, 0, 0 })
    );
    System.out.println(new Solution().maxDistToClosest(new int[] { 0, 1 }));
  }
}
