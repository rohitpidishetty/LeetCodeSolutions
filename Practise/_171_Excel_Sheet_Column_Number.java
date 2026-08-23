class Solution {
  public int titleToNumber(String columnTitle) {
    int colNum = 0;
    int magnitude = columnTitle.length() - 1;
    int charIdx = 0;
    while (magnitude >= 0) {
      colNum += (magnitude > 0 ? (int) Math.pow(26, magnitude) : 1) * (int) (columnTitle.charAt(charIdx) - 64);
      charIdx++;
      magnitude--;
    }
    return colNum;
  }
}

public class _171_Excel_Sheet_Column_Number {
  public static void main(String[] args) {
    System.out.println(new Solution().titleToNumber("ZY"));
  }
}
