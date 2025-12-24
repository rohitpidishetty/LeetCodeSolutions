import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

class Solution {

  public int thirdMax(int[] nums) {
    TreeSet<Integer> ts = new TreeSet<>();

    for (int n : nums) {
      ts.add(n);
      if (ts.size() > 3) ts.pollFirst();
    }
    if (ts.size() == 3) return ts.first();

    return ts.last();
  }
}

public class _414_Third_Maximum_Number {

  public static void main(String[] args) {
    System.out.println(new Solution().thirdMax(new int[] { 2, 1 }));
    // 2, 3, 2, 1, 3, 4, 4, 2
    // 4, 4, 3, 3, 2, 2, 2, 1
    // 4, 3, 2, 1
  }
}
