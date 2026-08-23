import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) return null;
    if (numRows == 1) return List.of(List.of(1));
    if (numRows == 2) return List.of(List.of(1), List.of(1, 1));
    List<List<Integer>> pasacl = new ArrayList<>();
    pasacl.add(new ArrayList<>(List.of(1)));
    pasacl.add(new ArrayList<>(List.of(1, 1)));
    int row = 2;
    while (row < numRows) {
      List<Integer> currentRow = new ArrayList<>();
      currentRow.add(1);
      int prevRow = row - 1;
      for (int j = 1; j < row; j++) currentRow.add(
        pasacl.get(prevRow).get(j) + pasacl.get(prevRow).get(j - 1)
      );
      currentRow.add(1);
      pasacl.add(currentRow);
      row++;
    }
    return pasacl;
  }
}

public class _118_Pascal_s_Triangle {

  public static void main(String[] args) {
    new Solution().generate(5);
  }
}
