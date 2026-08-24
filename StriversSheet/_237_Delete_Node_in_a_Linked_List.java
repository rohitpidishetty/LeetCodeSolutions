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

  public void deleteNode(ListNode node) {
    while (node.next != null) {
      node.val = node.next.val;
      if (node.next.next == null) {
        node.next = null;
        break;
      }
      node = node.next;
    }
  }
}

public class _237_Delete_Node_in_a_Linked_List {

  public static void main(String[] args) {
    ListNode e = new ListNode(10);
    ListNode d = new ListNode(9, e);
    ListNode c = new ListNode(1, d);
    ListNode b = new ListNode(5, c);
    ListNode a = new ListNode(4, b);
    new Solution().deleteNode(b);
    while (a != null) {
      System.out.println(a.val);
      a = a.next;
    }
  }
}
