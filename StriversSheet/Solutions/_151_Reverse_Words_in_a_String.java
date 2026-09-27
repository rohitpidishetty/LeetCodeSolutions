class Solution {

  public String reverseWords(String s) {
    s = s.trim();
    String[] buff = s.split("\\s");
    StringBuilder sb = new StringBuilder();
    for (int i = buff.length - 1; i >= 0; i--) {
      if (buff[i].length() == 0) continue;
      sb.append(buff[i].trim()).append(i != 0 ? " " : "");
    }
    return sb.toString();
  }
}

public class _151_Reverse_Words_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("the sky    is blue"));
  }
}
