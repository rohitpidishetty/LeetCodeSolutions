import java.util.*;

class Solution {

  public int findLHS(int[] nums) {
    int MAX = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
    for (int n : nums) {
      int min = n;
      int max = n + 1;
      if (map.containsKey(max)) MAX = Math.max(
        MAX,
        map.get(max) + map.get(min)
      );
    }

    return MAX;
  }
}

public class _594_Longest_Harmonious_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 })
    );
  }
}
