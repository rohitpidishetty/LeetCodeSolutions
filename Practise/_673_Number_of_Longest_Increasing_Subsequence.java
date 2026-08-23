import java.util.*;

class Solution {

  // Time Limit Exceeded 34 / 223 testcases passed
  // public int findNumberOfLIS(int[] nums) {
  //   int n = nums.length;
  //   Map<Integer, List<Integer>> pointers = new HashMap<>();
  //   for (int i = 0; i < n; i++) pointers.put(
  //     i,
  //     new ArrayList<>(Arrays.asList(1))
  //   );
  //   for (int i = 1; i < n; i++) {
  //     List<Integer> A = pointers.get(i);
  //     for (int j = 0; j < i; j++) {
  //       if (nums[j] < nums[i]) {
  //         List<Integer> buffer = pointers.get(j);
  //         for (int x : buffer) A.add(x + 1);
  //       }
  //     }
  //   }
  //   PriorityQueue<Integer> buffer = new PriorityQueue<>((a, b) ->
  //     Integer.compare(b, a)
  //   );
  //   for (Map.Entry<Integer, List<Integer>> m : pointers.entrySet()) {
  //     buffer.addAll(m.getValue());
  //   }

  //   int X = buffer.peek();
  //   int count = 0;
  //   while (!buffer.isEmpty() && buffer.poll() == X) count++;
  //   return count;
  // }

  public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    int[] LIS = new int[n];
    int[] freq = new int[n];
    Arrays.fill(LIS, 1);
    Arrays.fill(freq, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (LIS[j] + 1 > LIS[i]) {
            LIS[i] = LIS[j] + 1;
            freq[i] = freq[j];
          } else if (LIS[j] + 1 == LIS[i]) {
            freq[i] += freq[j];
          }
        }
      }
    }
    int maxLen = 0;
    for (int len : LIS) maxLen = Math.max(maxLen, len);
    int count = 0;
    for (int i = 0; i < n; i++) if (LIS[i] == maxLen) count += freq[i];
    return count;
  }
}

public class _673_Number_of_Longest_Increasing_Subsequence {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findNumberOfLIS(new int[] { 2, 2, 3, 4, 3, 5, 4, 6 })
    );
  }
}
