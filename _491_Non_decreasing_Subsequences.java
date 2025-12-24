import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<Integer>> findSubsequences(int[] nums) {
    int n = nums.length;
    Map<Integer, List<List<Integer>>> sub_seq_endings = new HashMap<>();
    for (int i = 0; i < n; i++)
      sub_seq_endings.put(i, new ArrayList<>());
    for (int i = 1; i < n; i++) {

      for (int j = 0; j < i; j++) {
        if (nums[j] <= nums[i]) {
          sub_seq_endings.get(i).add(new ArrayList<>(Arrays.asList(nums[j], nums[i])));
          // Add all the previous arrays that ended at j'th position.
          for (List<Integer> prev_sub_arrays : sub_seq_endings.get(j)) {
            List<Integer> curr_sub_arr = new ArrayList<>(prev_sub_arrays);
            curr_sub_arr.add(nums[i]);
            sub_seq_endings.get(i).add(curr_sub_arr);
          }
        }
      }
    }

    HashSet<List<Integer>> ret = new HashSet<>();

    for (Map.Entry<Integer, List<List<Integer>>> o : sub_seq_endings.entrySet()) {
      List<List<Integer>> buffer = o.getValue();
      if (buffer.size() > 0) {
        for (List<Integer> buf : buffer)
          ret.add(buf);

      }
    }

    return new ArrayList<>(ret);
  }
}

public class _491_Non_decreasing_Subsequences {
  public static void main(String[] args) {
    System.out.println(new Solution().findSubsequences(new int[] { 4, 6, 7, 7 }));
  }
}
