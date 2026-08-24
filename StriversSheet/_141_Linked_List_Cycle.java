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

  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      if (fast.next == null || fast.next.next == null) return false;
      fast = fast.next.next;
    } while (slow != fast && fast != null);

    return slow == fast;
  }
}

public class _141_Linked_List_Cycle {

  public static void main(String[] args) {
    System.out.println(
      new Solution().hasCycle(
        new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))))
      )
    );
  }
}
