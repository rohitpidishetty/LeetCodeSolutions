import java.util.ArrayList;
import java.util.List;

class Solution {
  private boolean isPalindrome(String s) {
    if (s.isEmpty())
      return false;
    int i = 0;
    int j = s.length() - 1;
    char[] tokens = s.toCharArray();
    while (i <= j) {
      if (tokens[i] != tokens[j])
        return false;
      i++;
      j--;
    }
    return true;
  }

  private void solve(String s, int start, int end, List<String> bucket, List<List<String>> ret) {
    if (end <= start) {
      ret.add(new ArrayList<>(bucket));
      return;
    }
    for (int i = start; i <= end; i++) {
      String selected = s.substring(start, i);
      if (isPalindrome(selected)) {
        bucket.add(selected);
        String rem = s.substring(i, end);
        solve(rem, 0, rem.length(), bucket, ret);
        bucket.remove(bucket.size() - 1);
      }

    }
  }

  public List<List<String>> partition(String s) {
    if (s.isEmpty())
      return null;
    List<List<String>> ret = new ArrayList<>();
    solve(s, 0, s.length(), new ArrayList<>(), ret);
    return ret;
  }
}

public class _131_Palindrome_Partitioning {
  public static void main(String[] args) {
    System.out.println(new Solution().partition("aab"));
  }
}
