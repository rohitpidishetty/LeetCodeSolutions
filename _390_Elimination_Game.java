class Solution {

  public int lastRemaining(int n) {
    int s = 1;
    boolean left = true;
    int h = 1;
    while (n > 1) {
      if (left || n % 2 == 1) h += s;
      n /= 2;
      s *= 2;
      left = !left;
    }
    return h;
  }
}

public class _390_Elimination_Game {

  public static void main(String[] args) {
    System.out.println(new Solution().lastRemaining(9));
  }
}
