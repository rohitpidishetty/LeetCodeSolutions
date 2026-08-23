// 78 Testcases passed
// class Solution {

//   private int sum(int[] buffer) {
//     int sum = 0;
//     for (int n : buffer) sum += n;
//     return sum;
//   }

//   private boolean dfs(
//     int[] nums,
//     int find,
//     int withSize_k,
//     int i,
//     int sumSoFar,
//     Boolean memo[][][]
//   ) {
//     if (withSize_k < 0) return false;
//     if (i == nums.length) return false;
//     if (find == sumSoFar) return true;

//     if (
//       memo[withSize_k][i][sumSoFar] != null
//     ) return memo[withSize_k][i][sumSoFar];

//     // skip
//     boolean skip = dfs(nums, find, withSize_k, i + 1, sumSoFar, memo);

//     // take
//     boolean take = dfs(
//       nums,
//       find,
//       withSize_k - 1,
//       i + 1,
//       sumSoFar + nums[i],
//       memo
//     );

//     return memo[withSize_k][i][sumSoFar] = skip || take;
//   }

//   public boolean splitArraySameAverage(int[] nums) {
//     int sum_a = sum(nums),
//       size_a = nums.length;

//     for (int k = 1; k <= (nums.length / 2); k++) {
//       if (((sum_a * k) % size_a) != 0) continue;

//       if (
//         dfs(
//           nums,
//           ((sum_a * k) / size_a),
//           k,
//           0,
//           0,
//           new Boolean[k + 1][size_a + 1][sum_a + 1]
//         )
//       ) return true;
//     }

//     return false;
//   }
// }

// public class _805_Split_Array_With_Same_Average {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().splitArraySameAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 })
//     );
//   }
// }
import java.util.*;

class Solution {

  public boolean splitArraySameAverage(int[] nums) {
    int n = nums.length,
      sum = 0;
    for (int num : nums) sum += num;

    Arrays.sort(nums);

    for (int k = 1; k <= n / 2; k++) {
      if ((sum * k) % n != 0) continue;
      int target = (sum * k) / n;

      if (dfs(nums, 0, k, target, new HashMap<>())) return true;
    }
    return false;
  }

  private boolean dfs(
    int[] nums,
    int index,
    int k,
    int target,
    Map<String, Boolean> memo
  ) {
    if (k == 0) return target == 0;
    if (index >= nums.length) return false;
    if (target < 0) return false;

    String key = index + "," + k + "," + target;
    if (memo.containsKey(key)) return memo.get(key);

    if (dfs(nums, index + 1, k - 1, target - nums[index], memo)) {
      memo.put(key, true);
      return true;
    }

    if (dfs(nums, index + 1, k, target, memo)) {
      memo.put(key, true);
      return true;
    }

    memo.put(key, false);
    return false;
  }
}
