import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> s = new Stack<>();
    for (int a : asteroids) {
      boolean antiDir = a < 0;
      int mag = Math.abs(a);
      if (antiDir) {
        boolean dontPush = false;
        while (!s.isEmpty() && s.peek() > 0 && mag > s.peek()) s.pop();
        if (!s.isEmpty() && mag == s.peek()) {
          s.pop();
          dontPush = true;
        }
        if (!dontPush) {
          if (!s.isEmpty() && s.peek() > 0 && s.peek() > mag) continue;
          s.push(a);
        }
      } else s.add(a);
    }
    int[] ret = new int[s.size()];
    int idx = ret.length - 1;
    while (!s.isEmpty()) ret[idx--] = s.pop();
    return ret;
  }
}

public class _735_Asteroid_Collision {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().asteroidCollision(new int[] { -2, -1, 1, 2 })
      )
    );
  }
}
