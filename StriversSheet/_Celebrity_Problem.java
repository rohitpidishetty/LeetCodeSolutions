import java.util.Arrays;

class Solution {

  // public int celebrity(int[][] M) {
  //   int n = M.length;
  //   int celebOutDegs[] = new int[n];
  //   int celebInDegs[] = new int[n];
  //   for (int i = 0; i < n; i++) {
  //     for (int j = 0; j < n; j++) {
  //       if (M[i][j] == 1) {
  //         celebOutDegs[i]++;
  //         celebInDegs[j]++;
  //       }
  //     }
  //   }

  //   for (int i = 0; i < n; i++) {
  //     if (celebInDegs[i] == n - 1 && celebOutDegs[i] == 0) return i;
  //   }
  //   return -1;
  // }

  public int celebrity(int[][] M) {
    int n = M.length;
    int candidate = 0;

    for (int i = 1; i < n; i++) {
      if (M[candidate][i] == 1) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i == candidate) continue;
      if (M[candidate][i] == 1 || M[i][candidate] == 0) return -1;
    }

    return candidate;
  }
}

public class _Celebrity_Problem {

  public static void main(String[] args) {
    System.out.println(
      new Solution().celebrity(
        new int[][] {
          { 0, 1, 1, 0 },
          { 0, 0, 0, 0 },
          { 1, 1, 0, 0 },
          { 0, 1, 1, 0 },
        }
      )
    );
  }
}
