import java.util.HashMap;
import java.util.Map;

class Solution {

  public String getHint(String secret, String guess) {
    int n = secret.length();
    int correct = 0;
    int[] misplaced = new int[1];
    Map<Character, Integer> sFreq = new HashMap<>();
    Map<Character, Integer> gFreq = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (secret.charAt(i) != guess.charAt(i)) {
        sFreq.put(
          secret.charAt(i),
          sFreq.getOrDefault(secret.charAt(i), 0) + 1
        );
        gFreq.put(guess.charAt(i), gFreq.getOrDefault(guess.charAt(i), 0) + 1);
      } else correct++;
    }
    gFreq.forEach((k, v) -> {
      if (sFreq.containsKey(k)) misplaced[0] += Math.min(
        sFreq.get(k),
        gFreq.get(k)
      );
    });
    return new StringBuilder()
      .append(correct)
      .append("A")
      .append(misplaced[0])
      .append("B")
      .toString();
  }
}

public class _299_Bulls_and_Cows {

  public static void main(String[] args) {
    System.out.println(new Solution().getHint("1807", "7810"));
  }
}
