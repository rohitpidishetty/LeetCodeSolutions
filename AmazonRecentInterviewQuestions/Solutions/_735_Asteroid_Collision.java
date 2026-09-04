import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < asteroids.length; i++) {
      boolean canBePushed = true;
      if (asteroids[i] < 0) {
        while (!s.isEmpty() && s.peek() >= 0) {
          if (Math.abs(asteroids[i]) == s.peek()) {
            s.pop();
            canBePushed = false;
            break;
          } else if (Math.abs(asteroids[i]) > s.peek()) s.pop();
          else {
            canBePushed = false;
            break;
          }
        }
      }
      if (canBePushed) s.push(asteroids[i]);
    }
    int[] res = new int[s.size()];
    int idx = res.length - 1;
    while (!s.isEmpty()) res[idx--] = s.pop();
    return res;
  }
}

public class _735_Asteroid_Collision {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().asteroidCollision(new int[] { 10, 2, -5 }))
    );
  }
}
