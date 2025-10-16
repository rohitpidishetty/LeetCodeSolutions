class Solution {
  public String smallestGoodBase(String n) {
    Long number = Long.valueOf(n);
    int slots = (int) ((Math.log(number) / Math.log(2)) + 1); // log_base2(number)
    for (int slot_magnitude = slots; slot_magnitude >= 2; slot_magnitude--) {

      long low = 2;
      long high = (int) Math.pow(number, 1.0 / (slot_magnitude - 1));

      while (low <= high) {
        long mid = (low + high) / 2;
        long sum = 1;
        long curr = 1;
        for (int i = 1; i < slot_magnitude; i++) {
          curr *= mid;
          sum += curr;
        }
        if (sum == number)
          return String.valueOf(mid);
        else if (sum < number)
          low = mid + 1;
        else
          high = mid - 1;
      }

    }
    return String.valueOf(number - 1);
  }
}

public class _483_Smallest_Good_Base {
  public static void main(String[] args) {
    System.out.println(new Solution().smallestGoodBase("13"));
  }
}
