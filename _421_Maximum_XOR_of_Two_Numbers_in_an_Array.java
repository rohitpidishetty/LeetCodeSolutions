import java.util.Arrays;

class BTrie {

  protected BTrie[] bucket;

  BTrie() {
    bucket = new BTrie[2];
  }
}

class Solution {

  public int findMaximumXOR(int[] nums) {
    BTrie root = new BTrie();
    int max = 0;
    for (int n : nums) {
      BTrie subRoot = root;
      for (int i = 31; i >= 0; i--) {
        int bit = (((1 << i) & n) == 0) ? 0 : 1;
        if (subRoot.bucket[bit] == null) subRoot.bucket[bit] = new BTrie();
        subRoot = subRoot.bucket[bit];
      }
    }

    for (int n : nums) {
      BTrie subRoot = root;
      int binary = 0;
      for (int i = 31; i >= 0; i--) {
        int bit = (((1 << i) & n) == 0) ? 0 : 1;
        int inverse = 1 - bit;
        if (subRoot.bucket[inverse] != null) {
          binary |= (inverse << i);
          subRoot = subRoot.bucket[inverse];
        } else {
          binary |= (bit << i);
          subRoot = subRoot.bucket[bit];
        }
      }
      max = Math.max(max, binary ^ n);
    }
    return max;
  }
}

public class _421_Maximum_XOR_of_Two_Numbers_in_an_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 })
    );
  }
}
