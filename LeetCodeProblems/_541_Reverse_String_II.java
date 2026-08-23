class Solution {
  public String reverseStr(String s, int k) {
    int i = 0, n = s.length(), win_size = 2 * k;

    StringBuilder sb = new StringBuilder();
    for (; i < n; i += 2 * k) {
      int start = i, end = Math.min(n, i + win_size) - 1;
      int size = end - start + 1;
      if (size == win_size)
        sb.append(new StringBuilder(s.substring(start, start + k))
            .reverse()
            .append(s
                .substring(start + k, end + 1)));
      else if (size == k)
        sb.append(new StringBuilder(s
            .substring(start, start + k))
            .reverse());
      else if (size > k)
        sb.append(new StringBuilder(s
            .substring(start, start + k))
            .reverse()
            .append(s
                .substring(start + k)));
      else if (size < k)
        sb.append(new StringBuilder(s
            .substring(start))
            .reverse());
    }
    return sb.toString();
  }
}

public class _541_Reverse_String_II {
  public static void main(String[] args) {
    System.out.println(new Solution().reverseStr("abcd", 2));
  }
}
