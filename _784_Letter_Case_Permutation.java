import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private void solve(char[] ch, int index, int n, ArrayList<String> buffer) {
    if (index == n) {
      buffer.add(new String(ch));
      return;
    }
    if (Character.isDigit(ch[index])) {
      solve(ch, index + 1, n, buffer);
      return;
    }

    ch[index] = Character.toLowerCase(ch[index]);
    solve(ch, index + 1, n, buffer);

    ch[index] = Character.toUpperCase(ch[index]);
    solve(ch, index + 1, n, buffer);
  }

  public List<String> letterCasePermutation(String s) {
    ArrayList<String> buffer = new ArrayList<>();
    solve(s.toCharArray(), 0, s.length(), buffer);

    return buffer;
  }
}

public class _784_Letter_Case_Permutation {

  public static void main(String[] args) {
    System.out.println(new Solution().letterCasePermutation(new String("Jw")));
  }
}
