import java.util.HashMap;
import java.util.Map;

class Solution {

  public int minSwapsCouples(int[] row) {
    Map<Integer, Integer> positions = new HashMap<>();
    int n = row.length, targetIdx, changeWith, fromLoc;

    for (int i = 0; i < n; i++) positions.put(row[i], i);
    int count = 0;
    for (int i = 0; i < n; i += 2) {
      if (row[i] % 2 == 0 && row[i + 1] != row[i] + 1) {
        swap(
          targetIdx = i + 1,
          changeWith = row[i] + 1,
          fromLoc = positions.get(changeWith),
          row,
          positions
        );
        count++;
      } else if ((row[i] % 2 != 0 && row[i + 1] != row[i] - 1)) {
        swap(
          targetIdx = i + 1,
          changeWith = row[i] - 1,
          fromLoc = positions.get(changeWith),
          row,
          positions
        );
        count++;
      }
    }

    return count;
  }

  private void swap(
    int tar,
    int chWith,
    int loc,
    int[] row,
    Map<Integer, Integer> positions
  ) {
    int temp = row[tar];
    row[tar] = chWith;
    row[loc] = temp;
    positions.put(row[tar], tar);
    positions.put(row[loc], loc);
  }
}

public class _765_Couples_Holding_Hands {

  public static void main(String[] args) {
    System.out.println(
      new Solution().minSwapsCouples(new int[] { 0, 2, 4, 6, 7, 1, 3, 5 })
    );
  }
}
