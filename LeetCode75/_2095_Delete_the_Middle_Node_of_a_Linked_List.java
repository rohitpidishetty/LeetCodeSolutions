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

  public ListNode deleteMiddle(ListNode head) {
    if (head.next == null) return null;
    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;
    do {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    } while (fast != null && fast.next != null);
    prev.next = slow == null ? null : slow.next;
    return head;
  }
}

public class _2095_Delete_the_Middle_Node_of_a_Linked_List {

  public static void main(String[] args) {
    ListNode head = new Solution().deleteMiddle(
      new ListNode(
        1,
        new ListNode(
          3,
          new ListNode(
            4,
            new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6))))
          )
        )
      )
    );
  }
}
