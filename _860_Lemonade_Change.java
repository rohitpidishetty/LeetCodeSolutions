import java.util.Arrays;

class Solution {

  public boolean lemonadeChange(int[] bills) {
    int earnings = 0;
    int fives = 0,
      tens = 0,
      twenties = 0;

    for (int bill : bills) {
      if (bill == 5) fives++;
      else {
        if (bill == 10) {
          if (fives <= 0) return false;
          tens++;
          fives--;
        } else if (bill == 20) {
          if (fives > 0 && tens > 0) {
            fives--;
            tens--;
          } else if (fives >= 3) fives -= 3;
          else return false;
          twenties++;
        }
      }
    }
    return true;
  }
}

public class _860_Lemonade_Change {

  public static void main(String[] args) {
    System.out.println(
      new Solution().lemonadeChange(new int[] { 5, 5, 5, 10, 20 })
    );
    System.out.println(
      new Solution().lemonadeChange(new int[] { 5, 5, 10, 10, 20 })
    );
    System.out.println(
      new Solution().lemonadeChange(
        new int[] { 5, 5, 5, 10, 5, 5, 10, 20, 20, 20 }
      )
    );
    System.out.println(
      new Solution().lemonadeChange(new int[] { 5, 5, 5, 20, 10, 10 })
    );
  }
}
