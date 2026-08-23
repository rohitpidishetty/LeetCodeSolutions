import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Integer> partitionLabels(String s) {
    int n = s.length();
    int offset = -1;
    int start = 0;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char currChar = s.charAt(i);
      int longRange = s.lastIndexOf(currChar);
      if (i == longRange && longRange >= offset) {
        ans.add(longRange - start + 1);
        offset = -1;
        start = i + 1;
      }
      if (longRange <= offset) continue;
      if (offset == -1 || longRange > offset) offset = longRange;
    }
    return ans;
  }
}

public class _763_Partition_Labels {

  public static void main(String[] args) {
    System.out.println(
      new Solution().partitionLabels(new String("eccbbbbdec"))
    );
  }
}
