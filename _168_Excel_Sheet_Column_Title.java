import java.util.ArrayList;
import java.util.List;

class Solution {
  public String convertToTitle(int columnNumber) {
    char ascii = 65;
    int mul = 25;
    String prev = new String();
    List<String> cols = new ArrayList<>();
    int j = 0;
    for (int i = 0; i < columnNumber; i++) {
      char ch = (char) (ascii + (i % 26));
      if (i > mul) {
        mul += 26;
        prev = cols.get(j);
        j++;
      }
      cols.add(String.valueOf(prev + ch));
    }
    return cols.get(cols.size() - 1);
  }
}

/**
 * Optimized
 * class Solution {
 * public String convertToTitle(int columnNumber) {
 * StringBuilder sb = new StringBuilder();
 * while (columnNumber > 0) {
 * columnNumber--; // Shift to 0-based index
 * int rem = columnNumber % 26;
 * sb.append((char) ('A' + rem));
 * columnNumber /= 26;
 * }
 * return sb.reverse().toString();
 * }
 * }
 * 
 */

public class _168_Excel_Sheet_Column_Title {
  public static void main(String[] args) {
    System.out.println(new Solution().convertToTitle(701));
  }
}