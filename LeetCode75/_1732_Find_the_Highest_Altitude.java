class Solution {

  public int largestAltitude(int[] gain) {
    int max = 0;
    int prefix = 0;
    for (int i = 0; i < gain.length; i++) {
      prefix += gain[i];
      max = Math.max(max, prefix);
    }
    return max;
  }
}

public class _1732_Find_the_Highest_Altitude {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 })
    );
  }
}
