class Solution {

  public long minimumSteps(String s) {
    int n = s.length();
    int blacks = 0;
    long steps = 0l;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') blacks++;
      else steps += blacks;
    }
    return steps;
  }
}

public class _2938_Separate_Black_and_White_Balls {

  public static void main(String[] args) {
    System.out.println(new Solution().minimumSteps("100"));
  }
}
