class Solution {

  public String customSortString(String order, String s) {
    int freq[] = new int[26];
    int n = s.length();
    for (int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
    n = order.length();
    StringBuilder sb = new StringBuilder();
    StringBuilder lazyAppend = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char ch = order.charAt(i);
      String _chs_ = String.valueOf(ch);
      if (freq[ch - 'a'] > 0) {
        sb.append(_chs_.repeat(freq[ch - 'a']));
        freq[ch - 'a'] = 0;
      }
    }
    for (int i = 0; i < 26; i++) {
      if (freq[i] > 0) sb.append(
        String.valueOf((char) (i + 'a')).repeat(freq[i])
      );
    }

    return sb.toString();
  }
}

public class _791_Custom_Sort_String {

  public static void main(String[] args) {
    System.out.println(new Solution().customSortString("bcafg", "abcd"));
  }
}
