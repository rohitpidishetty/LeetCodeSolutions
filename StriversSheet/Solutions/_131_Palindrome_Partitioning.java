import java.util.ArrayList;
import java.util.List;

class Solution {

  private boolean isPalindrome(int i, int j, String str) {
    while (i < j) {
      if (str.charAt(i) != str.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }

  private void solve(
    int s,
    int r,
    String str,
    List<List<String>> buff,
    List<String> temp
  ) {
    if (s == r) {
      buff.add(new ArrayList<>(temp));
      return;
    }

    for (int i = s; i < r; i++) {
      if (isPalindrome(s, i, str)) {
        temp.add(str.substring(s, i + 1));
        solve(i + 1, r, str, buff, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    int n = s.length();

    List<List<String>> buff = new ArrayList<>();
    solve(0, n, s, buff, new ArrayList<>());
    return buff;
  }
}

public class _131_Palindrome_Partitioning {

  public static void main(String[] args) {
    System.out.println(new Solution().partition("aab"));
  }
}
