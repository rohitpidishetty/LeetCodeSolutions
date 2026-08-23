// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Solution {

//   public List<Integer> largestDivisibleSubset(int[] nums) {
//     Arrays.sort(nums);
//     Map<Integer, List<Integer>> subSet = new HashMap<>();
//     int n = nums.length;
//     int[] dp = new int[n];
//     Arrays.fill(dp, 1);
//     for (int i = 0; i < n; i++) subSet.put(nums[i], new ArrayList<>());
//     for (int i = 1; i < n; i++) {
//       int max = 0;
//       for (int j = 0; j < i; j++) {
//         if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
//           dp[i] = dp[j] + 1;
//           subSet.get(nums[i]).clear();
//           subSet.get(nums[i]).addAll(subSet.get(nums[j]));
//           subSet.get(nums[i]).add(nums[i]);
//         }
//       }
//       // subSet.get(nums[i]).add(nums[i]);
//       dp[i] = max;
//     }
//     int maxIndex = 0;
//     for (int i = 1; i < n; i++) {
//       if (dp[i] > dp[maxIndex]) maxIndex = i;
//     }

//     return subSet.get(nums[maxIndex]);
//   }
// }

// public class _368_Largest_Divisible_Subset {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().largestDivisibleSubset(new int[] { 1, 4, 2, 3, 32, 8, 6 })
//     );
//   }
// }

import java.util.*;

class Solution {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    Map<Integer, List<Integer>> subSet = new HashMap<>();
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 0; i < n; i++) {
      subSet.put(nums[i], new ArrayList<>());
      subSet.get(nums[i]).add(nums[i]);
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          subSet.get(nums[i]).clear();
          subSet.get(nums[i]).addAll(subSet.get(nums[j]));
          subSet.get(nums[i]).add(nums[i]);
        }
      }
    }

    int maxIndex = 0;
    for (int i = 1; i < n; i++) {
      if (dp[i] > dp[maxIndex]) maxIndex = i;
    }

    return subSet.get(nums[maxIndex]);
  }
}

public class _368_Largest_Divisible_Subset {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestDivisibleSubset(new int[] { 1, 4, 2, 3, 32, 8, 6 })
    );
  }
}
