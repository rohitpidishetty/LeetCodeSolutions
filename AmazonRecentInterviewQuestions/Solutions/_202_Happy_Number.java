import java.util.HashSet;
import java.util.Set;

class Solution {

  public boolean isHappy(int n) {
    Set<Integer> visited = new HashSet<>();
    while (n != 1) {
      int nextNum = 0;
      while (n > 0) {
        int d = (n % 10);
        nextNum += (d * d);
        n /= 10;
      }

      if (nextNum == 1) return true;
      n = nextNum;
      if (visited.contains(n)) return false;
      visited.add(n);
    }
    return true;
  }
}

public class _202_Happy_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(19));
  }
}
