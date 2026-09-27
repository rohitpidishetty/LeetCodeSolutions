class Solution {

  private String solve(int n) {
    if (n == 1) return "1";
    if (n == 2) return "11";
    if (n == 3) return "21";
    if (n == 4) return "1211";
    String str = solve(n - 1);
    int m = str.length();
    int size = 0;
    Character curr = null;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      if (curr == null) {
        curr = str.charAt(i);
        size++;
        continue;
      }
      if (str.charAt(i) == curr) size++;
      else {
        sb.append(size).append(curr);
        curr = str.charAt(i);
        size = 1;
      }
    }
    sb.append(size).append(curr);
    return (sb.toString());
  }

  public String countAndSay(int n) {
    return solve(n);
  }
}

public class _38_Count_and_Say {

  public static void main(String[] args) {
    System.out.println(new Solution().countAndSay(6));
  }
}
