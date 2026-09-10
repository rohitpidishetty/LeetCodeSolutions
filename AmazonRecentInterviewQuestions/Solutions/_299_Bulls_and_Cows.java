import java.util.Arrays;

class Solution {

  public String getHint(String secret, String guess) {
    int n = secret.length();
    int[] secretMap = new int[10];
    int[] guessMap = new int[10];
    for (int i = 0; i < n; i++) secretMap[secret.charAt(i) - '0']++;
    for (int i = 0; i < n; i++) guessMap[guess.charAt(i) - '0']++;

    int A = 0;
    boolean[] discardIndex = new boolean[n];
    for (int i = 0; i < n; i++) {
      char s_ch = secret.charAt(i);
      char g_ch = guess.charAt(i);
      if (s_ch == g_ch) {
        secretMap[s_ch - '0']--;
        guessMap[g_ch - '0']--;
        discardIndex[i] = true;
        A++;
      }
    }
    int B = 0;
    for (int i = 0; i < n; i++) {
      if (!discardIndex[i]) B += (guessMap[secret.charAt(i) - '0']-- > 0
        ? 1
        : 0);
    }
    return A + "A" + B + "B";
  }
}

public class _299_Bulls_and_Cows {

  public static void main(String[] args) {
    System.out.println(new Solution().getHint("1122", "0001"));
  }
}
