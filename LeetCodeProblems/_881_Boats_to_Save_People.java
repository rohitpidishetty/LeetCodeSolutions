import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int l = 0;
    int r = people.length - 1;
    int count = 0;
    while (l <= r) {
      int total = people[l] + people[r];
      if (total <= limit) l++;
      r--;
      count++;
    }

    return count;
  }
}

public class _881_Boats_to_Save_People {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numRescueBoats(new int[] { 3, 2, 2, 1 }, 3)
    );
    System.out.println(
      new Solution().numRescueBoats(new int[] { 3, 5, 3, 4 }, 5)
    );
  }
}
