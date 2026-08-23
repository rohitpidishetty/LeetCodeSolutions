import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private static int toInt(int[] block) {
    int intVal = 0;
    for (int bit : block)
      intVal = (intVal << 1) | bit;
    return intVal;
  }

  private static void rec(int[] block, int s, List<Integer> buffer) {
    buffer.add(toInt(block));
    if (s == block.length)
      return;
    for (int i = s; i < block.length; i++) {
      block[i] = block[i] + 1;
      rec(block, i + 1, buffer);
      block[i] = 0;
    }
  }

  public List<Integer> grayCode(int n) {
    int bitLen = (int) (Math.ceil(Math.log(Math.pow(2, n)) / Math.log(2)));
    int[] bits = new int[bitLen];
    List<Integer> buffer = new ArrayList<>();
    rec(bits, 0, buffer);
    return buffer;
  }
}

public class _89_Gray_Code {
  public static void main(String[] args) {
    int n = 3;
    System.out.println(new Solution().grayCode(n));
  }
}
