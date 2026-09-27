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

  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}

public class _206_Reverse_Linked_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(
      1,
      new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
    );

    ListNode result = new Solution().reverseList(head);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
