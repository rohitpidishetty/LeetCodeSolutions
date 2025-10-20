import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Solution {
  // 203 / 223 testcases (Works fine for all positive ints)
  // public int[] nextGreaterElements(int[] nums) {
  // int n = nums.length;
  // // <Index, NGE>
  // Map<Integer, Integer> nextGreaterElementOnRight = new HashMap<>();
  // Map<Integer, Integer> leastGreaterElementOnLeft = new HashMap<>();
  // Stack<Integer> stack = new Stack<>();
  // ArrayDeque<Integer> queue1 = new ArrayDeque<>();
  // for (int i = n - 1; i >= 0; i--) {
  // while (!stack.isEmpty() && stack.peek() <= nums[i])
  // stack.pop();
  // int nge = stack.empty() ? -1 : stack.peek();
  // nextGreaterElementOnRight.put(i, nge);
  // stack.push(nums[i]);
  // }
  // queue1.offer(nums[0]);
  // for (int i = 1; i < n; i++)
  // if (nums[i] > queue1.getLast())
  // queue1.offer(nums[i]);
  // for (int i = 0; i < n; i++) {
  // if (nextGreaterElementOnRight.get(i) == -1) {
  // ArrayDeque<Integer> copy = new ArrayDeque<>(queue1);
  // while (!copy.isEmpty() && copy.peek() <= nums[i])
  // copy.poll();
  // if (!copy.isEmpty())
  // nextGreaterElementOnRight.put(i, copy.peek());
  // }
  // }
  // int[] buffer = new int[n];
  // for (int i = 0; i < n; i++) {
  // buffer[i] = nextGreaterElementOnRight.get(i);
  // }
  // return buffer;
  // }

  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] temp = new int[n + (n - 1)];
    int m = temp.length;
    Map<Integer, Integer> nextGreaterElementOnRight = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < m; i++)
      temp[i] = nums[(i < n) ? i : (i % n)];
    for (int i = m - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= temp[i])
        stack.pop();
      int nge = stack.empty() ? -1 : stack.peek();
      nextGreaterElementOnRight.put(i, nge);
      stack.push(temp[i]);
    }
    int[] buffer = new int[n];
    for (int i = 0; i < n; i++)
      buffer[i] = nextGreaterElementOnRight.get(i);
    return buffer;
  }
}

public class _503_Next_Greater_Element_II {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new Solution().nextGreaterElements(new int[] { 1, 8, -1, -100, -1, 222, 1111111, -111111 })));
  }
}
