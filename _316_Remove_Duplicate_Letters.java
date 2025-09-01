import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

  public String removeDuplicateLetters(String s) {
    char[] tokens = s.toCharArray();
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c - 'a']++;
    Stack<Character> S = new Stack<>();
    for (char ch : tokens) {
      freq[ch - 'a']--;
      if (S.contains(ch)) continue;
      while (!S.isEmpty() && S.peek() > ch && freq[S.peek() - 'a'] > 0) S.pop();
      S.push(ch);
    }
    StringBuilder sb = new StringBuilder();
    while (!S.isEmpty()) sb.append(S.pop());
    return sb.reverse().toString();
  }
}

public class _316_Remove_Duplicate_Letters {

  public static void main(String[] args) {
    System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
  }
}
