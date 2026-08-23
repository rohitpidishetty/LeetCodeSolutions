import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private List<int[]> freq(String s) {
    int n = s.length();
    int i = 0;
    List<int[]> freq = new ArrayList<>();
    while (i < n) {
      char ch = s.charAt(i);
      int j = i;
      while (j < n && s.charAt(j) == ch) j++;
      freq.add(new int[] { ch, j - i });
      i = j;
    }
    return freq;
  }

  public int expressiveWords(String s, String[] words) {
    List<int[]> frq = freq(s);
    int n = frq.size();
    int count = 0;

    for (String word : words) {
      List<int[]> match = freq(word);
      if (match.size() == n) {
        boolean status = true;
        for (int i = 0; i < n; i++) {
          int[] a = frq.get(i);
          int[] b = match.get(i);
          if (a[0] != b[0] || (b[1] < a[1] && a[1] < 3) || (a[1] < b[1])) {
            status = false;
            break;
          }
        }
        if (status) count++;
      }
    }
    return count;
  }
}

public class _809_Expressive_Words {

  public static void main(String[] args) {
    System.out.println(
      new Solution().expressiveWords(
        "zzzzzyyyyy",
        new String[] { "zzyy", "zy", "zyy" }
      )
    );

    System.out.println(
      new Solution().expressiveWords(
        "heeellooo",
        new String[] { "hello", "hi", "helo" }
      )
    );
  }
}
