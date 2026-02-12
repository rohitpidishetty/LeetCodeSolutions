import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

  public boolean isNStraightHand(int[] hand, int groupSize) {
    int n = hand.length;
    if (n % groupSize != 0) return false;
    int size = groupSize;
    TreeMap<Integer, Integer> freq = new TreeMap<>();
    for (int h : hand) freq.put(h, freq.getOrDefault(h, 0) + 1);

    while (!freq.isEmpty()) {
      int currentMember = freq.firstEntry().getKey();

      int x = freq.get(currentMember);
      if (x == 1) freq.remove(currentMember);
      else freq.put(currentMember, x - 1);
      for (int i = 1; i < groupSize; i++) {
        int nextMember = currentMember + i;
        if (!freq.containsKey(nextMember)) return false;
        int nextMemberFreq = freq.get(nextMember);
        if (nextMemberFreq < 1) return false;
        if (nextMemberFreq == 1) freq.remove(nextMember);
        else freq.put(nextMember, nextMemberFreq - 1);
      }
    }
    return true;
  }
}

public class _846_Hand_of_Straights {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3)
    );
    System.out.println(
      new Solution().isNStraightHand(new int[] { 1, 2, 3, 4, 5 }, 4)
    );
    System.out.println(new Solution().isNStraightHand(new int[] { 2, 1 }, 2));
    System.out.println(
      new Solution().isNStraightHand(new int[] { 8, 10, 12 }, 3)
    );
    System.out.println(
      new Solution().isNStraightHand(new int[] { 1, 1, 2, 2, 3, 3 }, 3)
    );
  }
}
