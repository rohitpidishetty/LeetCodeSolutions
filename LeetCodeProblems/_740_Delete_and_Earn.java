import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

// 49 / 52 Passed; (TLE)
// class Solution {

//   private Map<Integer, Integer> freq;
//   private Map<String, Integer> memo;

//   private int solve(List<Integer> buf, int index, Integer previous, int mag) {
//     String key = new StringBuilder().append(index).append(previous).toString();
//     if (this.memo.containsKey(key)) return this.memo.get(key);
//     if (index == mag) return 0;

//     // skip
//     int skip = solve(buf, index + 1, previous, mag);

//     // take
//     int n = buf.get(index);
//     if (previous != null && n - 1 == previous) {
//       this.memo.put(key, skip);
//       return skip;
//     }

//     int take = (n * this.freq.get(n)) + solve(buf, index + 1, n, mag);
//     int ans = Math.max(skip, take);
//     this.memo.put(key, ans);
//     return ans;
//   }

//   public int deleteAndEarn(int[] nums) {
//     this.freq = new HashMap<>();
//     this.memo = new HashMap<>();
//     TreeSet<Integer> buffer = new TreeSet<>();
//     for (int n : nums) {
//       buffer.add(n);
//       freq.put(n, freq.getOrDefault(n, 0) + 1);
//     }
//     int m = buffer.size();

//     Integer previous;
//     int index, sum, mag;

//     return solve(new ArrayList<>(buffer), index = 0, previous = null, mag = m);
//   }
// }

class Solution {

  public int deleteAndEarn(int[] nums) {
    TreeMap<Integer, Integer> freq = new TreeMap<>();
    for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
    int[] x = freq.keySet().stream().mapToInt(e -> (Integer) e).toArray();
    int[] y = new int[x.length];
    y[0] = x[0] * freq.get(x[0]);
    int i = 1;
    for (; i < x.length; i++) {
      // for every i, we have an option to take or skip
      int take = 0;
      int curr = x[i] * freq.get(x[i]);
      if (x[i - 1] + 1 == x[i]) {
        if (i - 2 >= 0) take = (curr + y[i - 2]);
        else take = curr;
      } else take = (curr + y[i - 1]);
      int skip = y[i - 1];
      y[i] = Math.max(take, skip);
    }
    return y[i - 1];
  }
}

public class _740_Delete_and_Earn {

  public static void main(String[] args) {
    System.out.println(
      new Solution().deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 })
    );
  }
}
