import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dsa {

  class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();
      for (String str : strs) {
        char[] tokens = str.toCharArray();
        Arrays.sort(tokens);
        // Key
        String key = new String(tokens);
        if (!map.containsKey(key)) {
          map.put(key, new ArrayList<>());
          map.get(key).add(str);
        } else map.get(key).add(str);
      }
      return new ArrayList<>(map.values());
    }

    public double myPow(double x, int n) {
      if (x == 1d) return x;
      double res = 1;
      long y = Math.abs((long) n); // correct conversion
      for (int i = 0; i < y; i++) res *= x;
      if (n > 0) return res;
      return 1 / res;
    }

    class inn {

      public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long exp = n;
        if (exp < 0) {
          x = 1 / x;
          exp = -exp;
        }
        double result = 1.0;
        while (exp > 0) {
          if ((exp % 2) == 1) result *= x;
          x *= x;
          exp /= 2;
        }
        return result;
      }
    }
  }

  public static void main(String[] args) {
    new dsa()
      .new Solution().groupAnagrams(
        new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }
      );

    System.out.println(new dsa().new Solution().myPow(2.00000, 2));
    System.out.println(new dsa().new Solution().new inn().myPow(2.00000, 5));
  }
}
