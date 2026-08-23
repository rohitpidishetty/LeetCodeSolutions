import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public boolean isHappy(int n) {
    Set<Integer> outcomes = new HashSet<>();
    int ans = n;
    while (ans != 1) {
      n = ans;
      int temp = 0;
      while (n > 0) {
        int LSN = (n % 10);
        temp += (LSN * LSN);
        n /= 10;
      }
      ans = temp;
      if (outcomes.contains(ans)) return false;
      outcomes.add(ans);
    }
    return true;
  }
}

public class _202_Happy_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(2));
  }
}
