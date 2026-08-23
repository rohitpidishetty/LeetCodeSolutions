import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public String[] findRelativeRanks(int[] score) {

    int i = 0, n = score.length, idx = n - 1;
    int[] original = Arrays.copyOf(score, n);
    String[] buffer = new String[n];

    Arrays.sort(score);

    Map<Integer, String> map = new HashMap<>();
    for (; i < n / 2; i++) {
      int temp = score[i];
      score[i] = score[idx];
      score[idx] = temp;
      idx--;
    }

    for (i = 0; i < n; i++)
      map.put(score[i],
          (i == 0 ? "Gold Medal" : (i == 1 ? "Silver Medal" : i == 2 ? "Bronze Medal" : String.valueOf(i + 1))));

    idx = 0;
    for (int x : original)
      buffer[idx++] = map.get(x);

    return buffer;
  }
}

public class _506_Relative_Ranks {
  public static void main(String[] args) {
    System.out.println(new Solution().findRelativeRanks(new int[] { 10, 3, 8, 9 }));
  }
}
