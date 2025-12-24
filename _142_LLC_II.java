import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode sp = head;
    Set<ListNode> pointers = new HashSet<>();
    while (sp != null) {
      if (pointers.contains(sp))
        return sp;
      pointers.add(sp);
      sp = sp.next;
    }
    return null;
  }
}

public class _142_LLC_II {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);

    // Configuration
    n1.next = n2;
    n2.next = n1;

    System.out.println(n1 + " " + n2);
    System.out.println(new Solution().detectCycle(n1).val);
  }
}
