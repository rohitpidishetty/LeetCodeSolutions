import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {

  // V0
  public int lengthOfLIS_v0(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int max = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      System.out.println(stack);
      int insertNum = nums[i];
      while (!stack.isEmpty() && nums[stack.peek()] <= insertNum) stack.pop();
      stack.push(i);
      max = Math.max(max, stack.size());
    }
    return max;
  }

  // V1
  private int max;

  private void solve(int[] nums, int start, List<Integer> buffer) {
    if (start > nums.length - 1) return;
    buffer.add(nums[start]);
    max = Math.max(max, buffer.size());
    for (int i = start + 1; i < nums.length; i++) {
      if (nums[start] < nums[i]) solve(nums, i, buffer);
    }
    buffer.remove(buffer.size() - 1);
  }

  public int lengthOfLIS_v1(int[] nums) {
    max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) solve(nums, i, new ArrayList<>());
    return max;
  }

  // V2

  private int[] memo;

  private int solve_v2(int[] nums, int start) {
    if (memo[start] != -1) return memo[start];
    if (start >= nums.length) return 0;

    int returnValue = 0;
    for (int i = start + 1; i < nums.length; i++) {
      if (nums[start] < nums[i]) returnValue = Math.max(
        returnValue,
        1 + solve_v2(nums, i)
      );
    }
    memo[start] = returnValue;
    return returnValue;
  }

  public int lengthOfLIS(int[] nums) {
    memo = new int[nums.length];
    Arrays.fill(memo, -1);
    max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int ret = 1 + solve_v2(nums, i);
      max = Math.max(max, ret);
    }
    return max;
  }
}

public class _300_Longest_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 })
    );
  }
}
