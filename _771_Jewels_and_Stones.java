import java.util.HashSet;
import java.util.Set;

class Solution {

  public int numJewelsInStones(String jewels, String stones) {
    Set<Character> s = new HashSet<>();
    int n = jewels.length();
    for (int i = 0; i < n; i++) s.add(jewels.charAt(i));
    n = stones.length();
    int jewelsCount = 0;
    for (int i = 0; i < n; i++) {
      if (s.contains(stones.charAt(i))) jewelsCount++;
    }
    return jewelsCount;
  }
}

public class _771_Jewels_and_Stones {

  public static void main(String[] args) {
    System.out.println(new Solution().numJewelsInStones("aA", "aAAbbb"));
  }
}
