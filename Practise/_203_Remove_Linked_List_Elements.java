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

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
    dummyNode.next = head;
    ListNode currentNode = dummyNode;
    while (currentNode.next != null) {
      if (currentNode.next.val == val) {
        if (currentNode.next.next == null) {
          currentNode.next = null;
          break;
        } else {
          ListNode linkedTo = currentNode.next;
          currentNode.next = linkedTo.next;
          linkedTo.next = null;
        }
      } else currentNode = currentNode.next;
    }
    return dummyNode.next;
  }
}

public class _203_Remove_Linked_List_Elements {

  public static void main(String[] args) {
    ListNode head = new ListNode(
      7,
      new ListNode(7, new ListNode(7, new ListNode(97)))
    );
    head = new Solution().removeElements(head, 7);
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next == null ? null : head.next;
    }
  }
}
