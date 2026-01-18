import java.util.Arrays;

class Solution {

  public int[] numberOfLines(int[] widths, String s) {
    int sum = 0,
      row = 1;
    for (char ch : s.toCharArray()) {
      if (sum + widths[ch - 'a'] > 100) {
        sum = 0;
        row++;
      }
      sum += widths[ch - 'a'];
    }

    return new int[] { row, sum };
  }
}

public class _806_Number_of_Lines_To_Write_String {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().numberOfLines(
          new int[] {
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
          },
          new String("abcdefghijklmnopqrstuvwxyz")
        )
      )
    );
  }
}
