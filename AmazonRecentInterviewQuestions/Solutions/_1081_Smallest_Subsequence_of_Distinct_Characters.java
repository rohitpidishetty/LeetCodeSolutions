import java.util.Stack;

class Solution {

  public String smallestSubsequence(String s) {
    short[] lastIndexOf = new short[26];
    boolean[] used = new boolean[26];
    int n = s.length();
    for (int i = 0; i < n; i++) lastIndexOf[s.charAt(i) - 'a'] = (short) i;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      while (
        !stack.isEmpty() &&
        stack.peek() > ch &&
        lastIndexOf[stack.peek() - 'a'] > i &&
        !used[ch - 'a']
      ) used[stack.pop() - 'a'] = false;

      if (used[ch - 'a']) continue;
      stack.push(ch);
      used[ch - 'a'] = true;
    }
    StringBuilder ans = new StringBuilder();

    while (!stack.isEmpty()) ans.append(stack.pop());
    return ans.reverse().toString();
  }
}

public class _1081_Smallest_Subsequence_of_Distinct_Characters {

  public static void main(String[] args) {
    System.out.println(
      new Solution().smallestSubsequence("cbaacabcaaccaacababa")
    );
  }
}
