import java.util.*;

class Solution {

  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    char[] ch1 = s1.toCharArray();
    char[] ch2 = s2.toCharArray();
    int n = s1.length(), m = s2.length();

    int i = 0, j = 0, count_s2 = 0;
    while (n1 > 0) {
      if (ch1[i] == ch2[j]) {
        j++;
        if (j == m) {
          j = 0;
          count_s2++;
        }
      }
      i++;
      if (i == n) {
        i = 0;
        n1--;
      }
    }

    return count_s2 / n2;
  }
}

public class _466_Count_The_Repetitions {

  public static void main(String[] args) {
    System.out.println(new Solution().getMaxRepetitions("acb", 3, "ab", 1));
  }
}
