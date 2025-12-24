class Solution {

  public char nextGreatestLetter(char[] letters, char target) {
    for (char ch : letters) if (ch > target) return ch;
    return letters[0];
  }
}

public class _744_Find_Smallest_Letter_Greater_Than_Target {

  public static void main(String[] args) {
    System.out.println(
      new Solution().nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a')
    );
  }
}
