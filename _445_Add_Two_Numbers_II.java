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

  private ListNode reverse(ListNode h) {
    ListNode newHead = null;
    while (h != null) {
      ListNode next = h.next;
      h.next = newHead;
      newHead = h;
      h = next;
    }
    return newHead;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    int cf = 0;
    ListNode l3 = new ListNode(0);
    ListNode dummy = l3;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + cf;
      if (sum > 9) {
        l3.next = new ListNode(sum % 10);
        l3 = l3.next;
        cf = 1;
      } else {
        l3.next = new ListNode(sum);
        l3 = l3.next;
        cf = 0;
      }
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      int sum = l1.val + cf;
      if (sum > 9) {
        l3.next = new ListNode(sum % 10);
        l3 = l3.next;
        cf = 1;
      } else {
        l3.next = new ListNode(sum);
        l3 = l3.next;
        cf = 0;
      }
      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + cf;
      if (sum > 9) {
        l3.next = new ListNode(sum % 10);
        l3 = l3.next;
        cf = 1;
      } else {
        l3.next = new ListNode(sum);
        l3 = l3.next;
        cf = 0;
      }
      l2 = l2.next;
    }

    if (cf == 1) {
      l3.next = new ListNode(1);
      l3 = l3.next;
    }

    return reverse(dummy.next);
  }
}

public class _445_Add_Two_Numbers_II {

  public static void main(String[] args) {
    ListNode l3 = new Solution()
      .addTwoNumbers(
        new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
        new ListNode(5, new ListNode(6, new ListNode(4)))
      );
    while (l3 != null) {
      System.out.println(l3.val);
      l3 = l3.next;
    }
  }
}
