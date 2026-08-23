import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
  public String reverseWords(String s) {
    return Arrays.stream(s.split(" "))
        .map(e -> new StringBuilder(e)
            .reverse()
            .toString())
        .collect(Collectors.joining(" "));
  }
}

public class _557_Reverse_Words_in_a_String_III {
  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
  }
}
