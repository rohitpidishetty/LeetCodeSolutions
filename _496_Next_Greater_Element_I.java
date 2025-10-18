import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums2.length - 1;
    Map<Integer, Integer> m = new HashMap<>();
    Stack<Integer> s = new Stack<>();
    s.push(nums2[n]);
    m.put(nums2[n], -1);
    for (int i = n - 1; i >= 0; i--) {
      while (!s.isEmpty() && s.peek() < nums2[i])
        s.pop();
      m.put(nums2[i], s.size() == 0 ? -1 : s.peek());
      s.push(nums2[i]);
    }
    int idx = 0;
    int[] ans = new int[nums1.length];
    for (int n1 : nums1)
      ans[idx++] = m.get(n1);
    return ans;
  }
}

public class _496_Next_Greater_Element_I {
  public static void main(String[] args) {
    System.out
        .println(Arrays.toString(
            new Solution().nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
  }
}
