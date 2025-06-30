import java.util.Arrays;

public class RegEx {
  private boolean match(String regex, String pattern) {
    char[] reg_T = regex.toCharArray();
    char[] pat_T = pattern.toCharArray();
    boolean[][] mat = new boolean[pat_T.length + 1][reg_T.length + 1];
    mat[0][0] = true;
    for (int j = 2; j < mat[0].length; j++) {
      if (reg_T[j - 1] == '*')
        mat[0][j] = mat[0][j - 2];
    }
    int i = 1;
    int j = 1;
    for (; i < mat.length; i++) {
      for (j = 1; j < mat[0].length; j++) {
        if (reg_T[j - 1] == '.' || pat_T[i - 1] == reg_T[j - 1])
          mat[i][j] = mat[i - 1][j - 1];
        else if (reg_T[j - 1] == '*') {
          mat[i][j] = mat[i][j - 2];
          if (reg_T[j - 2] == pat_T[i - 1] || reg_T[j - 2] == '.')
            mat[i][j] |= mat[i - 1][j];
        }
      }
    }
    System.out.println(Arrays.deepToString(mat));
    return mat[i - 1][j - 1];
  }

  public static void main(String[] args) {
    System.out.println(new RegEx().match(".*", "ab"));
  }
}
