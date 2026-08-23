import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int findShortestSubArray(int[] nums) {
    Map<Integer, int[]> freq = new HashMap<>();
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int key = nums[i];
      if (!freq.containsKey(key)) {
        freq.put(key, new int[] { 1, i, 0 });
      } else {
        int[] buffer = freq.get(key);
        buffer[0]++;
        max = Math.max(max, buffer[0]);
        buffer[2] = i;
        freq.put(key, buffer);
      }
    }

    List<List<int[]>> buffer = new ArrayList<>();
    for (Map.Entry<Integer, int[]> map : freq.entrySet()) {
      int[] buff = map.getValue();
      int val = map.getKey();
      int idx = buff[0];
      while (buffer.size() <= idx) buffer.add(new ArrayList<>());
      buffer.get(idx).add(buff);
    }

    List<int[]> _max_ = buffer.get(buffer.size() - 1);
    int min = Integer.MAX_VALUE;
    int m = _max_.size();
    for (int i = 0; i < m; i++) {
      int[] _buff_ = _max_.get(i);
      min = Math.min(min, (_buff_[2] - _buff_[1]) + 1);
    }
    return min <= 0 ? 1 : min;
  }
}

public class _697_Degree_of_an_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 })
    );
  }
}
