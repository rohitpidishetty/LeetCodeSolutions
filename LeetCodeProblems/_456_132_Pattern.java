import java.util.Stack;

class Solution {

  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) return false;
    Stack<Integer> s = new Stack<>();
    int middle_at_j = Integer.MIN_VALUE, largest_at_k = 0, smallest_at_i =
      Integer.MIN_VALUE, n = nums.length - 1;

    for (int i = n; i >= 0; i--) {
      smallest_at_i = nums[i];
      if (middle_at_j > smallest_at_i) return true;
      while (!s.isEmpty() && smallest_at_i > s.peek()) middle_at_j = s.pop();
      s.push(nums[i]);
    }
    return false;
  }
}

public class _456_132_Pattern {

  public static void main(String[] args) {
    System.out.println(new Solution().find132pattern(new int[] { 3, 1, 4, 2 }));
  }
}
