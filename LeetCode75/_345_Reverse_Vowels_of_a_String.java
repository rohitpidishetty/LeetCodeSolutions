class Solution {

  public String reverseVowels(String s) {
    char[] tokens = s.toCharArray();
    StringBuilder vowels = new StringBuilder();

    int n = tokens.length;
    for (int i = 0; i < n; i++) {
      if (
        tokens[i] == 'a' ||
        tokens[i] == 'e' ||
        tokens[i] == 'i' ||
        tokens[i] == 'o' ||
        tokens[i] == 'u' ||
        tokens[i] == 'A' ||
        tokens[i] == 'E' ||
        tokens[i] == 'I' ||
        tokens[i] == 'O' ||
        tokens[i] == 'U'
      ) {
        vowels.append(tokens[i]);
        tokens[i] = '\0';
      }
    }

    vowels = vowels.reverse();
    int idx = 0;
    for (int i = 0; i < n; i++) {
      if (tokens[i] == '\0') tokens[i] = vowels.charAt(idx++);
    }

    return new String(tokens);
  }
}

public class _345_Reverse_Vowels_of_a_String {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseVowels("IceCreAm"));
  }
}
