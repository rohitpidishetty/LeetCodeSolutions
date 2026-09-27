class Solution {

  public int romanToInt(String s) {
    short[] map = new short[26];
    map[8] = 1;
    map[21] = 5;
    map[23] = 10;
    map[11] = 50;
    map[2] = 100;
    map[3] = 500;
    map[12] = 1000;
    int i = s.length() - 1;
    int ans = 0;
    int prev = Integer.MIN_VALUE;
    while (i > -1) {
      int curr = map[s.charAt(i) - 'A'];
      ans = (prev <= curr) ? ans + curr : ans - curr;
      prev = curr;
      i--;
    }
    return ans;
  }
}

public class _13_Roman_to_Integer {

  public static void main(String[] args) {
    System.out.println(new Solution().romanToInt("MCMXCIV"));
  }
}
