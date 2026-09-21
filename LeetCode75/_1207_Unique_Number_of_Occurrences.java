import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    Set<Integer> s = new HashSet<>(map.values());
    return s.size() == map.values().size();
  }
}

public class _1207_Unique_Number_of_Occurrences {

  public static void main(String[] args) {
    System.out.println(
      new Solution().uniqueOccurrences(
        new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3 }
      )
    );
  }
}
