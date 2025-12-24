import java.util.*;

class Solution {

  public String[] findRestaurant(String[] list1, String[] list2) {
    int n = list1.length, m = list2.length;
    String[] min_list = n < m ? list1 : list2, max_list = n < m ? list2 : list1;
    Map<String, Integer> map = new HashMap<>();
    int idx = 0;
    List<String> res = new ArrayList<>();
    int max = Integer.MAX_VALUE;
    for (String val : min_list) map.put(val, idx++);

    idx = 0;
    for (String val : max_list) {
      if (map.containsKey(val)) {
        int v = map.get(val) + idx;

        if (v < max) {
          res.clear();
          res.add(val);
          max = v;
        } else if (v == max) res.add(val);
      }
      idx++;
    }
    return res.toArray(new String[0]);
  }
}

public class _599_Minimum_Index_Sum_of_Two_Lists {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .findRestaurant(
            new String[] { "happy", "sad", "good" },
            new String[] { "sad", "happy", "good" }
          )
      )
    );
  }
}
