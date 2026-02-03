import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<List<Integer>> largeGroupPositions(String s) {
    int j = 0,
      i = 0,
      n = s.length();
    List<List<Integer>> buffer = new ArrayList<>();
    while (j < n) {
      char ch = s.charAt(j);
      if (!(j + 1 < n && ch == s.charAt(j + 1))) {
        if (j - i + 1 >= 3) buffer.add(Arrays.asList(i, j));
        i = j + 1;
      }
      j++;
    }

    return buffer;
  }
}

public class _830_Positions_of_Large_Groups {

  public static void main(String[] args) {
    System.out.println(new Solution().largeGroupPositions("abcdddeeeeaabbbcd"));
  }
}
