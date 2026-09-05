import java.util.Arrays;
import java.util.Stack;

class Solution {

  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    int leftLimit[] = new int[n];
    int rightLimit[] = new int[n];
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
      leftLimit[i] = s.isEmpty() ? -1 : s.peek();
      s.push(i);
    }

    s.clear();
    for (int i = n - 1; i > -1; i--) {
      while (!s.isEmpty() && arr[s.peek()] > arr[i]) s.pop();
      rightLimit[i] = s.isEmpty() ? n : s.peek();
      s.push(i);
    }

    int MOD = 1_000_000_007;
    long ans = 0;
    for (int i = 0; i < n; i++) {
      long left = i - leftLimit[i];
      long right = rightLimit[i] - i;

      ans = (ans + arr[i] * left * right) % MOD;
    }
    return (int) ans;
  }
}

public class _907_Sum_of_Subarray_Minimums {

  public static void main(String[] args) {
    System.out.println(
      new Solution().sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 })
    );
  }
}
