class Solution {

  public int countSegments(String s) {
    if (s.length() == 0) return 0;
    int i = 0;
    while (Character.isSpaceChar(s.charAt(i))) i++;
    return s.substring(i).split("[\\s]+").length;
  }
}

public class _434_Number_of_Segments_in_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().countSegments("    foo    bar"));
  }
}
