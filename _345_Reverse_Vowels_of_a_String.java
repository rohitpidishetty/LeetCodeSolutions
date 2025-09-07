class Solution {

  public String reverseVowels(String s) {
    if (s.isEmpty()) return s;
    char[] tokens = s.toCharArray();
    int i = 0, j = tokens.length - 1;
    while (i <= j) {
      while (
        i < j &&
        tokens[i] != 'a' &&
        tokens[i] != 'e' &&
        tokens[i] != 'i' &&
        tokens[i] != 'o' &&
        tokens[i] != 'u' &&
        tokens[i] != 'A' &&
        tokens[i] != 'E' &&
        tokens[i] != 'I' &&
        tokens[i] != 'O' &&
        tokens[i] != 'U'
      ) i++;
      while (
        i < j &&
        tokens[j] != 'a' &&
        tokens[j] != 'e' &&
        tokens[j] != 'i' &&
        tokens[j] != 'o' &&
        tokens[j] != 'u' &&
        tokens[j] != 'A' &&
        tokens[j] != 'E' &&
        tokens[j] != 'I' &&
        tokens[j] != 'O' &&
        tokens[j] != 'U'
      ) j--;
      if (i >= j) break;
      char temp = tokens[i];
      tokens[i] = tokens[j];
      tokens[j] = temp;
      i++;
      j--;
    }
    return new String(tokens);
  }
}

public class _345_Reverse_Vowels_of_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseVowels(" "));
  }
}
