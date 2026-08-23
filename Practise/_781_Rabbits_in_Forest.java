import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int numRabbits(int[] answers) {
    Map<Integer, Integer> groups = new HashMap<>();
    int ans = 0;

    for (int rabbit : answers) {
      int groupSize = rabbit + 1;
      if (!groups.containsKey(groupSize) || groups.get(groupSize) == 0) {
        ans += groupSize;
        groups.put(groupSize, rabbit);
      } else groups.put(groupSize, groups.get(groupSize) - 1);
    }

    return ans;
  }
}

public class _781_Rabbits_in_Forest {

  public static void main(String[] args) {
    System.out.println(new Solution().numRabbits(new int[] { 1, 0, 1, 0, 0 }));
  }
}
