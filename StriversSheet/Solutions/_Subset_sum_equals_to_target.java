class Solution {

  private boolean solve(
    int[] arr,
    int T,
    int idx,
    int n,
    int sumSoFar,
    Boolean memo[][]
  ) {
    if (sumSoFar == T) return true;
    if (idx == n || sumSoFar > T) return false;
    if (memo[idx][sumSoFar] != null) return memo[idx][sumSoFar];

    // skip
    boolean skip = solve(arr, T, idx + 1, n, sumSoFar, memo);

    // take
    boolean take = solve(arr, T, idx + 1, n, sumSoFar + arr[idx], memo);
    return memo[idx][sumSoFar] = skip || take;
  }

  public boolean isSubsetSum(int[] arr, int target) {
    Boolean[][] memo = new Boolean[arr.length][target + 1];

    return solve(arr, target, 0, arr.length, 0, memo);
  }
}

public class _Subset_sum_equals_to_target {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsetSum(new int[] { 1, 2, 7, 3 }, 6));
  }
}
