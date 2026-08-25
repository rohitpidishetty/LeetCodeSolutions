class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {

  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      if (fast.next == null || fast.next.next == null) return null;
      fast = fast.next.next;
    } while (slow != fast);
    slow = head;

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}

public class _142_Linked_List_Cycle_II {

  public static void main(String[] args) {
    ListNode d = new ListNode(-4);
    ListNode c = new ListNode(0, d);
    ListNode b = new ListNode(2, c);
    ListNode a = new ListNode(3, b);

    d.next = b;
    System.out.println(new Solution().detectCycle(a));
  }
}
