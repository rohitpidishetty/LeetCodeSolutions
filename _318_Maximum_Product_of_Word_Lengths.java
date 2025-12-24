import java.util.Arrays;

class Solution {

  public int maxProduct(String[] words) {
    int[] bits_arr = new int[words.length];
    int idx = 0;
    for (String word : words) {
      char[] tokens = word.toCharArray();
      int[] bit_buffer = new int[26];
      for (int ascii : tokens) bit_buffer[Math.abs(ascii - 122)] = 1;
      int binary_rep = 0;
      int i = 25;
      for (int bit : bit_buffer) binary_rep |= (bit << i--);
      bits_arr[idx++] = binary_rep;
    }
    int max = 0;
    for (int i = 0; i < bits_arr.length; i++) {
      for (int j = 0; j < bits_arr.length; j++) {
        if (i == j) continue;
        if ((bits_arr[i] & bits_arr[j]) == 0) max = Math.max(
          max,
          words[i].length() * words[j].length()
        );
      }
    }
    return max;
  }
}

public class _318_Maximum_Product_of_Word_Lengths {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .maxProduct(
          new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }
        )
    );
  }
}
