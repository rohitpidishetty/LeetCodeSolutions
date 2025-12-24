import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  private Map<String, Integer> memoize = new HashMap<>();

  private int partition(String s) {
    if (s.isEmpty())
      return 1;
    if (s.charAt(0) == '0')
      return 0;

    int c = 0;
    if (memoize.containsKey(s))
      return memoize.get(s);

    c = partition(s.substring(1));
    if (s.length() >= 2) {
      int n = Integer.parseInt(s.substring(0, 2));
      if (n <= 26 && n >= 10)
        c += partition(s.substring(2));
    }
    memoize.put(s, c);
    return c;
  }

  public int numDecodings(String s) {
    return partition(s);
  }
}

public class _91_Decode_Ways {
  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("2263"));
  }
}