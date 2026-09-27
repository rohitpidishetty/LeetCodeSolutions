import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> greaterRight = new HashMap<>();
    int i = nums2.length - 1;
    Stack<Integer> monotonicStack = new Stack<>();
    while (i >= 0) {
      while (
        !monotonicStack.isEmpty() && monotonicStack.peek() < nums2[i]
      ) monotonicStack.pop();
      greaterRight.put(
        nums2[i],
        monotonicStack.isEmpty() ? -1 : monotonicStack.peek()
      );
      monotonicStack.push(nums2[i]);
      i--;
    }
    int res[] = new int[nums1.length];
    for (i = 0; i < nums1.length; i++) res[i] = greaterRight.get(nums1[i]);
    return res;
  }
}

public class _496_Next_Greater_Element_I {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().nextGreaterElement(
          new int[] { 4, 1, 2 },
          new int[] { 1, 3, 4, 2 }
        )
      )
    );
  }
}
