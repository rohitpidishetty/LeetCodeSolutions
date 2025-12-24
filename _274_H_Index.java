import java.util.Arrays;

class Solution {

  public int hIndex(int[] citations) {
    if (citations.length == 1 && citations[0] > 0) return 1;
    if (citations.length == 1 && citations[0] <= 0) return 0;
    Arrays.sort(citations);
    int paperCount = 1;
    for (int i = citations.length - 1; i >= 0; i--) {
      if (citations[i] < paperCount) return paperCount - 1;
      paperCount++;
    }
    return citations.length;
  }
}

public class _274_H_Index {

  public static void main(String[] args) {
    System.out.println(new Solution().hIndex(new int[] { 3, 0, 6, 1, 5 }));
  }
}
