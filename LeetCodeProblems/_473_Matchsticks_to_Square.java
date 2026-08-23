import java.util.Arrays;

class Solution {
  private int globalPointer = 0;
  private int threshold = 0;
  private int[] ms_buffer;

  public boolean makesquare(int[] matchsticks) {
    Arrays.sort(matchsticks);
    int sum = Arrays.stream(matchsticks).sum();
    if (sum % 4 != 0)
      return false;
    int target = sum / 4;
    this.threshold = matchsticks.length;
    this.ms_buffer = matchsticks;
    int[] square_sides = { 0, 0, 0, 0 };
    return dfs(square_sides, target);
  }

  private boolean dfs(int[] square_sides, int target) {
    if (globalPointer >= threshold)
      return (square_sides[0] == target) && (square_sides[2] == target)
          && (square_sides[1] == target && square_sides[3] == target);

    for (int i = 0; i < 4; i++) {
      if ((i > 0 && square_sides[i] == square_sides[i - 1])
          || (globalPointer < threshold && square_sides[i] + ms_buffer[globalPointer] > target))
        continue;

      square_sides[i] += ms_buffer[globalPointer++];
      if (dfs(square_sides, target))
        return true;
      square_sides[i] -= ms_buffer[--globalPointer];
    }
    return false;
  }
}

public class _473_Matchsticks_to_Square {
  public static void main(String[] args) {
    System.out.println(new Solution().makesquare(new int[] { 1, 1, 2, 2, 2 }));
  }
}
