import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Solution {

  private Map<Integer, List<Integer>> freq;
  private Random rand;

  public Solution(int[] nums) {
    freq = new HashMap<>();
    rand = new Random();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (!freq.containsKey(nums[i])) freq.put(nums[i], new ArrayList<>());
      freq.get(nums[i]).add(i);
    }
  }

  public int pick(int target) {
    if (freq.containsKey(target)) {
      List<Integer> frq = freq.get(target);
      return frq.get(rand.nextInt(frq.size()));
    }
    return 0;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
public class _398_Random_Pick_Index {

  public static void main(String[] args) {
    Solution obj = new Solution(new int[] { 1, 2, 3, 3, 3 });
    System.out.println(obj.pick(3));
  }
}
