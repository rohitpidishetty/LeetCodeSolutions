import java.util.Arrays;

class Solution {

  public String pushDominoes(String dominoes) {
    int n = dominoes.length();

    int left[] = new int[n];
    int right[] = new int[n];

    char ch;
    for (int i = 0; i < n; i++) {
      ch = dominoes.charAt(i);
      if (ch == 'R') left[i] = i;
      else if (ch == '.') left[i] = i > 0 ? left[i - 1] : -1;
      else left[i] = -1;
    }

    for (int i = n - 1; i >= 0; i--) {
      ch = dominoes.charAt(i);
      if (ch == 'L') right[i] = i;
      else if (ch == '.') right[i] = i < n - 1 ? right[i + 1] : -1;
      else right[i] = -1;
    }

    StringBuilder finalDominoes = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int distL = Math.abs(i - left[i]);
      int distR = Math.abs(i - right[i]);
      if (left[i] == -1 && right[i] == -1) finalDominoes.append('.');
      else if (left[i] == -1) finalDominoes.append('L');
      else if (right[i] == -1) finalDominoes.append('R');
      else {
        if (distL < distR) finalDominoes.append('R');
        else if (distL > distR) finalDominoes.append('L');
        else finalDominoes.append('.');
      }
    }

    return finalDominoes.toString();
  }
}

public class _838_Push_Dominoes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().pushDominoes(new String(".L.R...LR..L.."))
    );
  }
}
