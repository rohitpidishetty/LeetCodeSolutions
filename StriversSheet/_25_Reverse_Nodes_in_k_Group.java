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

  private ListNode[] reverse(ListNode s, ListNode e) {
    ListNode prev = null;
    ListNode S = s;
    while (S != null) {
      ListNode save = S.next;
      S.next = prev;
      prev = S;
      S = save;
    }
    return new ListNode[] { prev, s };
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    int counter = 1;
    ListNode start = head;
    ListNode root = dummy;
    while (head != null) {
      if (counter % k == 0) {
        // Break
        ListNode next = head.next;
        head.next = null;
        ListNode[] ln = reverse(start, head);
        dummy.next = ln[0];
        dummy = ln[1];
        head = next;
        start = head;
      } else head = head.next;
      counter++;
    }
    dummy.next = start;
    return root.next;
  }
}

public class _25_Reverse_Nodes_in_k_Group {

  public static void main(String[] args) {
    ListNode head = new Solution().reverseKGroup(
      new ListNode(
        1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
      ),
      2
    );
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
