class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode sp = head;
    ListNode fp = head.next;
    while (fp != null && fp.next != null) {
      if (sp == fp)
        return true;
      sp = sp.next;
      fp = fp.next.next;
    }
    return false;
  }
}

public class _141_Linked_List_Cycle {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(3);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(0);
    ListNode n4 = new ListNode(-4);

    // Configuration
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;

    System.out.println(new Solution().hasCycle(n1));
  }
}
