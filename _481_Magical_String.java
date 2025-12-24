import java.util.ArrayList;
import java.util.List;

class Solution {
  public int magicalString(int n) {
    if (n == 0)
      return 0;
    if (n <= 3)
      return 1;

    int[] start = { 1, 2, 2 };
    List<Integer> buff = new ArrayList<>();
    for (int num : start)
      buff.add(num);

    int pointer = 2;
    int lastEditedNum = 2;
    int count = 1;

    while (buff.size() < n) {
      int next = 3 - lastEditedNum;
      int times = buff.get(pointer);

      for (int i = 0; i < times && buff.size() < n; i++) {
        buff.add(next);
        if (next == 1)
          count++;
      }

      lastEditedNum = next;
      pointer++;
    }

    return count;
  }
}

public class _481_Magical_String {
  public static void main(String[] args) {
    System.out.println(new Solution().magicalString(6));
    System.out.println(new Solution().magicalString(10));
  }
}
