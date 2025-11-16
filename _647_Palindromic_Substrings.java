import java.util.*;

class Solution {

  private Set<String> visited;

  private boolean is_palindrome(String word) {
    int i = 0;
    int j = word.length() - 1;
    while (i <= j) {
      if (word.charAt(i) != word.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  private Map<String, Integer> memo;

  private int solve(String s) {
    if (this.memo.containsKey(s)) return this.memo.get(s);

    if (s.length() == 0) return 0;
    int count = 0;
    int n = s.length();
    int ret = 0;
    for (int i = 1; i <= n; i++) {
      String consider = s.substring(0, i);
      if (is_palindrome(consider)) count++;
      String next = s.substring(i);
      if (visited.contains(next)) continue;
      visited.add(next);
      count += solve(next);
    }
    this.memo.put(s, count);
    return count;
  }

  public int countSubstrings(String s) {
    this.visited = new HashSet<>();
    this.memo = new HashMap<>();
    int c = solve(s);
    return c;
  }
}

public class _647_Palindromic_Substrings {

  public static void main(String[] args) {
    System.out.println(new Solution().countSubstrings(new String("aaa")));
  }
}
