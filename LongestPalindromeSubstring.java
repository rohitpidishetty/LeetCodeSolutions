import java.util.Arrays;

public class LongestPalindromeSubstring {
  private String LPSs(String word) {

    int n = word.length();
    if (n < 2)
      return word;
    int matrix[][] = new int[n][n];
    char[] tokens = word.toCharArray();

    int i = 0, j = 0;
    while (i < n) {
      j = 0;
      while (j < n) {
        if (i == j)
          matrix[i][j] = 1;
        j++;
      }
      i++;
    }

    int x = 0;
    int max = Integer.MIN_VALUE;
    String s = new String();
    boolean entry = true;
    for (i = 0; i < n; i++) {
      if (entry) {
        for (j = i + 1; j < n; j++) {
          if ((tokens[i] == tokens[j] && matrix[i + 1][j - 1] == 1) ||
              tokens[i] == tokens[j] && i + 1 == j) {
            matrix[i][j] = 1;
            if (max < (j - i) + 1) {
              max = (j - i) + 1;
              s = word.substring(i, j + 1);
            }

          } else
            matrix[i][j] = 0;
          i++;
          if (j == n - 1) {
            i = 0;
            j = ++x;
          }
          if (i == 0 && j == n - 1) {
            i = n + 1;
            entry = false;
          }

        }
      }
    }
    return (max == Integer.MIN_VALUE) ? String.valueOf(tokens[0]) : s;
  }

  public static void main(String[] args) {
    System.out.println(new LongestPalindromeSubstring().LPSs("ababd"));
    System.out.println(new LongestPalindromeSubstring().LPSs("ac"));
  }
}
