import java.util.Arrays;

class Solution {

  public int firstUniqChar(String s) {
    int[] chars = new int[26];
    int n = s.length();
    for (int i = 0; i < n; i++) chars[(s.charAt(i) - 'a')]++;
    for (int i = 0; i < n; i++) if (chars[(s.charAt(i) - 'a')] == 1) return i;
    return -1;
  }
}

public class _387_First_Unique_Character_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().firstUniqChar("loveleetcode"));
  }
}
