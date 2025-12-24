import java.util.Stack;

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

  public void reorderList(ListNode head) {
    if (head == null)
      return;
    ListNode temp = head;
    Stack<ListNode> bucket = new Stack<>();
    temp = head;
    ListNode fp = temp;
    ListNode sp = temp;
    while (fp.next != null && fp.next.next != null) {
      sp = sp.next;
      fp = fp.next.next;
    }
    ListNode svals = sp.next;
    while (svals != null) {
      bucket.push(new ListNode(svals.val));
      svals = svals.next;
    }
    sp.next = null;

    while (temp != null) {
      ListNode save = temp.next;
      if (bucket.isEmpty()) {
        temp.next = null;
      } else {

        temp.next = bucket.pop();
        temp.next.next = save;
      }

      temp = save;
    }
    // while (head != null) {
    // System.out.println(head.val);
    // head = head.next;
    // }

  }
}

public class _143_Reorder_List {
  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    new Solution().reorderList(head);
  }
}
