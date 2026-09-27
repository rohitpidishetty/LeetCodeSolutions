import java.util.Arrays;

class Solution {

  public int[] findMissingRepeatingNumbers(int[] nums) {
    boolean[] present = new boolean[nums.length];
    int rep = 0;
    for (int i = 0; i < present.length; i++) {
      if (present[nums[i] - 1]) rep = nums[i];
      present[nums[i] - 1] = true;
    }

    for (int i = 0; i < present.length; i++) {
      if (!present[i]) return new int[] { i + 1, rep };
    }

    return null;
  }
}

public class _Find_the_repeating_and_missing_number {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().findMissingRepeatingNumbers(
          new int[] { 6, 5, 7, 1, 8, 6, 4, 3, 2 }
        )
      )
    );
  }
}
