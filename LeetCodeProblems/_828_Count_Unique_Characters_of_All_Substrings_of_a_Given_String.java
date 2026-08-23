import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int uniqueLetterString(String s) {
    List<List<Integer>> occ = new ArrayList<>();
    for (int i = 0; i < 26; i++) occ.add(new ArrayList<>(Arrays.asList(-1)));
    int n = s.length();
    for (int i = 0; i < n; i++) occ.get(s.charAt(i) - 'A').add(i);
    int count = 0;

    for (int i = 0; i < 26; i++) {
      int m = occ.get(i).size();
      if (m == 1) continue;
      for (int j = 1; j < m; j++) {
        count +=
          (occ.get(i).get(j) - occ.get(i).get(j - 1)) *
          ((j + 1 < m ? occ.get(i).get(j + 1) : n) - occ.get(i).get(j));
      }
    }
    return count;
  }
}

public class _828_Count_Unique_Characters_of_All_Substrings_of_a_Given_String {

  public static void main(String[] args) {
    System.out.println(new Solution().uniqueLetterString("ABA"));
  }
}
