
import java.util.Stack;

class Solution {
  // 860 / 885 testcases passed
  // public int arrayNesting(int[] nums) {
  // int n = nums.length;
  // Stack<Integer> s = new Stack<>();
  // int max = Integer.MIN_VALUE;
  // for (int i = 0; i < n; i++) {
  // boolean[] visited = new boolean[n];
  // visited[i] = true;
  // s.push(nums[i]);
  // while (!s.isEmpty() && !visited[s.peek()]) {
  // int next_idx = s.peek();
  // visited[next_idx] = true;
  // s.push(nums[next_idx]);
  // }
  // max = Math.max(max, s.size());
  // s.clear();
  // }
  // return max;
  // }

  public int arrayNesting(int[] nums) {
    int n = nums.length;
    Stack<Integer> s = new Stack<>();
    int max = Integer.MIN_VALUE;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        s.push(i);
        int count = 0;
        while (!s.isEmpty()) {
          int idx = s.pop();
          if (!visited[idx]) {
            visited[idx] = true;
            s.push(nums[idx]);
            count++;
          }
        }
        max = Math.max(max, count);
      }
    }
    return max;
  }
}

public class _565_Array_Nesting {
  public static void main(String[] args) {
    System.out.println(new Solution().arrayNesting(new int[] { 0, 2, 1 }));
  }
}