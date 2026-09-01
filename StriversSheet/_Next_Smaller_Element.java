import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int[] nextSmallerElements(int[] arr) {
    Stack<Integer> s = new Stack<>();
    int res[] = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && s.peek() > arr[i]) s.pop();
      res[i] = s.isEmpty() ? -1 : s.peek();
      s.push(arr[i]);
    }
    return res;
  }
}

public class _Next_Smaller_Element {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().nextSmallerElements(new int[] { 10, 9, 8, 7 })
      )
    );
  }
}
