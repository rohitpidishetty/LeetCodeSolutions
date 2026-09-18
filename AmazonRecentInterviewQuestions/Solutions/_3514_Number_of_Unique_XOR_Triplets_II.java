import java.util.HashSet;
import java.util.Set;

class Solution {

  public int uniqueXorTriplets(int[] nums) {
    Set<Integer> pairs = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) pairs.add(nums[i] ^ nums[j]);
    }

    // for()
    Integer[] p = pairs.toArray(new Integer[0]);
    int m = p.length;
    pairs.clear();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) pairs.add(p[j] ^ nums[i]);
    }
    return pairs.size();
  }
}

public class _3514_Number_of_Unique_XOR_Triplets_II {

  public static void main(String[] args) {
    System.out.println(
      new Solution().uniqueXorTriplets(new int[] { 6, 7, 8, 9 })
    );
  }
}
