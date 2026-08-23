import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i <= numRows; i++) {
      if (i == 0)
        ret.add(new ArrayList<>(Arrays.asList(1)));
      else if (i == 1)
        ret.add(new ArrayList<>(Arrays.asList(1, 1)));
      else {
        int k = 0;
        Object vec[] = ret.getLast().toArray();
        List<Integer> new_vec = new ArrayList<>();
        new_vec.add(1);
        for (int j = 1; j < vec.length; j++)
          new_vec.add((int) vec[k] + (int) vec[(k++) + 1]);
        new_vec.add(1);
        ret.add(new_vec);
      }

    }
    return ret.getLast();
  }
}

public class _118_Pascals_triangle {
  public static void main(String[] args) {
    System.out.println(new Solution().generate(0));
  }
}
