class Solution {

  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int limit = (minutesToTest / minutesToDie) + 1;
    int pigs = 0;

    while (Math.pow(limit, pigs) < buckets) pigs++;

    return pigs;
  }
}

public class _458_Poor_Pigs {

  public static void main(String[] args) {
    System.out.println(new Solution().poorPigs(4, 15, 15));
  }
}
