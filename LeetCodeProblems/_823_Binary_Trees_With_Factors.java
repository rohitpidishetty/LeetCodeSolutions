import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int numFactoredBinaryTrees(int[] arr) {
    Arrays.sort(arr);
    Map<Integer, Integer> heads = new HashMap<>();
    int count = arr.length;
    for (int n : arr) heads.put(n, 1);
    for (int i = 1; i < arr.length; i++) {
      int curr = arr[i];
      for (int j = 0; j < i; j++) {
        if (curr % arr[j] == 0 && heads.containsKey(curr / arr[j])) {
          heads.put(
            curr,
            (int) ((heads.get(curr) +
                ((1L * heads.get(arr[j]) * heads.get(curr / arr[j])) %
                  1_000_000_007)) %
              1_000_000_007)
          );
        }
      }
    }

    long total = 0;
    for (int val : heads.values()) total = (total + val) % 1_000_000_007;
    return (int) total;
  }
}

public class _823_Binary_Trees_With_Factors {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numFactoredBinaryTrees(new int[] { 18, 3, 6, 2 })
    );
  }
}
