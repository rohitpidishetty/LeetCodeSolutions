import java.util.List;

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

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    int index = 1;
    ListNode dummy = new ListNode(0);
    ListNode newHead = dummy;
    ListNode prev = null;
    ListNode temp = head;
    while (temp != null) {
      ListNode save = temp.next;

      if (index % 2 == 0) {
        newHead.next = temp;
        newHead = newHead.next;
        prev.next = temp.next;
        temp.next = null;
      }

      prev = temp;
      temp = save;
      index++;
    }

    temp = head;
    while (temp.next != null) temp = temp.next;

    temp.next = dummy.next;

    return head;
  }
}

public class _328_Odd_Even_Linked_List {

  public static void main(String[] args) {
    // 1,2,3,4,5,6,7,8
    ListNode l = new Solution().oddEvenList(
      new ListNode(
        1,
        new ListNode(
          2,
          new ListNode(
            3,
            new ListNode(
              4,
              new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))
            )
          )
        )
      )
    );

    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }
}
