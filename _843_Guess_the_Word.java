/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

class Solution {

  public void findSecretWord(String[] words, Master master) {
    int match = -1;
    int attempts = 0;
    Random rand = new Random();
    while (match != 6 && attempts < 10 && words.length > 0) {
      int random = rand.nextInt(words.length);
      // Filter
      String choosen = words[random];
      match = master.guess(choosen);
      List<String> consider = new ArrayList<String>();
      for (int i = 0; i < words.length; i++) {
        if (i == random) continue;
        int similarity = 0;
        for (int j = 0; j < 6; j++) if (
          choosen.charAt(j) == words[i].charAt(j)
        ) similarity++;
        // Consider only these
        if (similarity == match) consider.add(words[i]);
      }
      words = consider.toArray(new String[0]);
      attempts++;
    }
  }
}

public class _843_Guess_the_Word {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findSecretWord(
        new String[] { "acckzz", "ccbazz", "eiowzz", "abcczz" },
        new Master("acckzz")
      )
    );
  }
}
