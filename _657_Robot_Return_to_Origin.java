class Solution {

  public boolean judgeCircle(String moves) {
    int R_count = 0, L_count = 0, U_count = 0, D_count = 0;
    for (char move : moves.toCharArray()) {
      switch (move) {
        case 'R':
          R_count++;
          break;
        case 'L':
          L_count++;
          break;
        case 'U':
          U_count++;
          break;
        case 'D':
          D_count++;
          break;
      }
    }

    return (R_count == L_count) && (U_count == D_count);
  }
}

public class _657_Robot_Return_to_Origin {

  public static void main(String[] args) {
    System.out.println(new Solution().judgeCircle("UD"));
  }
}
