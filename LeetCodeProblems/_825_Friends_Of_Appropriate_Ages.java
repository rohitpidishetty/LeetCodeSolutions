import java.util.Arrays;

class Solution {

  public int numFriendRequests(int[] ages) {
    Arrays.sort(ages);
    int i = 1;
    int counter = 0;
    int j = 0;
    for (i = 0; i < ages.length; i++) {
      if (ages[i] < 15) continue;
      // Pointer 2 - Skip all unnecessary friends
      while (j < i && (ages[j] <= 0.5 * ages[i] + 7)) j++;

      int rangeOfFriends = i - j;

      int same = 0;
      int l = i - 1;
      while (l >= j && ages[i] == ages[l]) {
        same++;
        l--;
      }
      counter += (rangeOfFriends + same);
    }
    return counter;
  }
}

public class _825_Friends_Of_Appropriate_Ages {

  public static void main(String[] args) {
    System.out.println(new Solution().numFriendRequests(new int[] { 16, 16 }));
  }
}
