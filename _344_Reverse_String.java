import java.util.Arrays;

class Solution {

  public void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;
    int m = (j + 1) / 2;
    while (i < m) {
      char temp = s[i];
      s[i++] = s[j];
      s[j--] = temp;
    }
  }
}

public class _344_Reverse_String {

  public static void main(String[] args) {
    char[] buffer = new char[] { 'h', 'e', 'l', 'l', 'o' };
    new Solution().reverseString(buffer);
    System.out.println(Arrays.toString(buffer));
  }
}
