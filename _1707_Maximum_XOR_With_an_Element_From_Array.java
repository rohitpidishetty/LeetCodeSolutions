import java.util.Arrays;

class Solution {

  private class BitTrieNode {

    private BitTrieNode[] bits;

    public BitTrieNode() {
      bits = new BitTrieNode[2];
      // [0,1]
    }
  }

  private void insert(int num, BitTrieNode btn) {
    BitTrieNode seed = btn;
    for (int i = 31; i > -1; i--) {
      int index = (num & (1 << i)) == 0 ? 0 : 1;
      if (seed.bits[index] == null) seed.bits[index] = new BitTrieNode();
      seed = seed.bits[index];
    }
  }

  private int maxXORwith(int num, BitTrieNode seed) {
    int xor_with = 0;
    for (int i = 31; i > -1; i--) {
      int index = (num & (1 << i)) == 0 ? 0 : 1;
      int inverse = 1 - index;
      if (seed.bits[inverse] != null) {
        xor_with |= (inverse << i);
        seed = seed.bits[inverse];
      } else {
        xor_with |= (index << i);
        seed = seed.bits[index];
      }
    }
    return xor_with;
  }

  public int[] maximizeXor(int[] nums, int[][] queries) {
    int[][] arr = new int[queries.length][3];
    for (int i = 0; i < queries.length; i++) {
      arr[i] = new int[] { queries[i][0], queries[i][1], i };
    }
    BitTrieNode btn = new BitTrieNode();
    int ans[] = new int[queries.length];
    Arrays.sort(arr, (a, b) -> a[1] - b[1]);
    Arrays.sort(nums);
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      BitTrieNode seed = btn;
      int treeOf = arr[i][1];
      while (j < nums.length && nums[j] <= treeOf) {
        insert(nums[j], btn);
        j++;
      }
      if (j == 0) ans[arr[i][2]] = -1;
      else ans[arr[i][2]] = (arr[i][0] ^ maxXORwith(arr[i][0], seed));
    }
    return ans;
  }
}

public class _1707_Maximum_XOR_With_an_Element_From_Array {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().maximizeXor(
          new int[] { 5, 2, 4, 6, 6, 3 },
          new int[][] { { 12, 4 }, { 8, 1 }, { 6, 3 } }
        )
      )
    );
    System.out.println(
      Arrays.toString(
        new Solution().maximizeXor(
          new int[] { 0, 1, 2, 3, 4 },
          new int[][] { { 3, 1 }, { 1, 3 }, { 5, 6 } }
        )
      )
    );
  }
}
