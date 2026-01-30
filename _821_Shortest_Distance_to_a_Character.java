import java.util.Arrays;

class Solution {

  public int[] shortestToChar(String s, char c) {
    int n = s.length();
    int left_distance[] = new int[n];
    int right_distance[] = new int[n];
    int ans[] = new int[n];
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == c) left_distance[i] = i;
      else left_distance[i] = (i == 0)
        ? Integer.MAX_VALUE
        : left_distance[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == c) right_distance[i] = i;
      else right_distance[i] = (i == n - 1)
        ? Integer.MAX_VALUE
        : right_distance[i + 1];
    }

    for (int i = 0; i < n; i++) ans[i] = Math.min(
      Math.abs(left_distance[i] - i),
      Math.abs(right_distance[i] - i)
    );

    return ans;
  }
}

public class _821_Shortest_Distance_to_a_Character {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().shortestToChar("loveleetcode", 'e'))
    );
  }
}
