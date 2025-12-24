import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private int maxSum;

  private void solve(List<Integer> buffer, int sum, int size) {
    if (buffer.isEmpty()) {
      maxSum = Math.max(maxSum, sum);
      return;
    }
    int idx = 0;
    for (; idx < size;) {
      int SUM =
        sum +
        (idx == 0 ? 1 : buffer.get(idx - 1)) *
        buffer.get(idx) *
        (idx >= size - 1 ? 1 : buffer.get(idx + 1));

      List<Integer> temp = new ArrayList<>(buffer);
      temp.remove(idx);
      solve(temp, SUM, size - 1);
      idx++;
    }
  }

  public int maxCoins(int[] nums) {
    maxSum = 0;
    List<Integer> buffer = new ArrayList<>();
    for (int num : nums) buffer.add(num);
    solve(buffer, 0, nums.length);
    return maxSum;
  }
}

public class _312_Burst_Balloons {

  public static void main(String[] args) {
    System.out.println(new Solution().maxCoins(new int[] { 1, 5 }));
  }
}
