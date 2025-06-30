class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null && n >= 1)
      return null;
    int idx = -1;
    ListNode curr = head;
    while (curr != null) {
      idx++;
      curr = curr.next;
    }
    idx -= n;
    if (idx == -1)
      return head.next;
    int i = 0;
    curr = head;
    while (curr != null) {
      if (i == idx)
        curr.next = curr.next.next;
      i++;
      curr = curr.next;
    }
    return head;
  }
}

public class _18 {

  private static ListNode buildTree() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);

    return root;
  }

  public static void main(String[] args) {
    ListNode list = new Solution().removeNthFromEnd(_18.buildTree(), 1);
    while (list != null) {
      System.out.println(list.val);
      list = list.next;
    }

  }
}
