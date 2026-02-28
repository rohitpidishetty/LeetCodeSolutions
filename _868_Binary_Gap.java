import java.util.Arrays;

class Solution {

  public int binaryGap(int n) {
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (i < 31) sb.append((n & (1 << (i++))) == 0 ? 0 : 1);
    String binary = sb.toString();
    int b = binary.length();
    int max = 0;
    int prev = -1;
    for (i = 0; i < b; i++) {
      if (binary.charAt(i) == '1') {
        if (prev != -1) max = Math.max(max, i - prev);
        prev = i;
      }
    }

    return max;
  }
}

public class _868_Binary_Gap {

  public static void main(String[] args) {
    System.out.println(new Solution().binaryGap(6));
    System.out.println(new Solution().binaryGap(5));
  }
}
