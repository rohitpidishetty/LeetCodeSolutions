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

  public ListNode middleNode(ListNode head) {
    if (head.next == null) return head;
    if (head.next.next == null) return head.next;
    ListNode slow = head;
    ListNode fast = head;
    do {
      slow = slow.next;
      fast = fast.next.next;
    } while (fast.next != null && fast.next.next != null);
    return fast.next == null ? slow : slow.next;
  }
}

public class _876_Middle_of_the_Linked_List {

  public static void main(String[] args) {
    System.out.println(
      new Solution().middleNode(
        new ListNode(
          1,
          new ListNode(
            2,
            new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))
          )
        )
      ).val
    );

    System.out.println(
      new Solution().middleNode(
        new ListNode(
          1,
          new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
        )
      ).val
    );
  }
}
