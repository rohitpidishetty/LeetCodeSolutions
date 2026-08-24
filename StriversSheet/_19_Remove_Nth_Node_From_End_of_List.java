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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 0;
    ListNode root = head;
    while (root != null) {
      root = root.next;
      len++;
    }
    int counter = 1;
    ListNode h = head;
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      if ((len - counter + 1) == n) {
        if (prev == null) return head.next;
        prev.next = next;
        break;
      }
      prev = head;
      head = next;
      counter++;
    }
    return h;
  }
}

public class _19_Remove_Nth_Node_From_End_of_List {

  public static void main(String[] args) {
    ListNode head = new Solution().removeNthFromEnd(
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
