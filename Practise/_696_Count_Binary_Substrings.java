class Solution {

  public int countBinarySubstrings(String s) {
    int prev = 0, cur = 1, result = 0, n = s.length();
    if (n <= 1) return 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == s.charAt(i - 1)) cur++;
      else {
        result += Math.min(prev, cur);
        prev = cur;
        cur = 1;
      }
    }
    result += Math.min(prev, cur);
    return result;
  }
}

public class _696_Count_Binary_Substrings {

  public static void main(String[] args) {
    System.out.println(new Solution().countBinarySubstrings("100111001"));
  }
}
