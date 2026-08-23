import java.util.ArrayList;
import java.util.List;

class Solution {

  // private void solve(List<Character> num_arr, int index, int k, int limit) {
  //   if (index >= limit) return;
  //   if (k == 0) {
  //     System.out.println(num_arr);
  //     return;
  //   }
  //   solve(num_arr, index + 1, k, limit); //skip
  //   List<Character> temp = new ArrayList<>(num_arr);
  //   if (index >= temp.size()) return;
  //   temp.remove(index);
  //   solve(temp, index + 1, k - 1, limit);
  //   // take
  // }

  public String removeKdigits(String num, int k) {
    // int index = 0;
    // List<Character> buffer = new ArrayList<>();
    int n = num.length();
    // for (int i = 0; i < n; i++) buffer.add(num.charAt(i));
    // solve(buffer, index, k, n);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      char ch = num.charAt(i);
      // System.out.println(ch);

      int j = sb.length() - 1;
      while (sb.length() > 0 && k > 0 && sb.charAt(j) > ch) {
        sb.deleteCharAt(j);
        j--;
        k--;
      }
      sb.append(ch);
    }

    while (k-- > 0 && sb.length() > 0) sb.deleteCharAt(sb.length() - 1);

    int i = 0;
    while (i < sb.length() && sb.charAt(i) == '0') i++;
    String res = (i == sb.length()) ? "0" : sb.substring(i);

    return res;
  }
}

public class _402_Remove_K_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().removeKdigits("112", 1));
  }
}
