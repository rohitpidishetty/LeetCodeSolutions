import java.util.ArrayList;
import java.util.List;

class Solution {

  private boolean isSelfDividing(int num) {
    int n = num;
    while (n != 0) {
      int den = n % 10;
      if (den == 0 || num % den != 0) return false;
      n /= 10;
    }
    return true;
  }

  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> ret = new ArrayList<>();
    for (int i = left; i <= right; i++) if (isSelfDividing(i)) ret.add(i);
    return ret;
  }
}

public class _728_Self_Dividing_Numbers {

  public static void main(String[] args) {
    System.err.println(new Solution().selfDividingNumbers(1, 22));
  }
}
