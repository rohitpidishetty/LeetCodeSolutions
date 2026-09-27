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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = 0;
      if (sum >= 10) carry = 1;
      ListNode curr = new ListNode(sum % 10);
      dummy.next = curr;
      dummy = dummy.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      carry = 0;
      if (sum >= 10) carry = 1;
      ListNode curr = new ListNode(sum % 10);
      dummy.next = curr;
      dummy = dummy.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      carry = 0;
      if (sum >= 10) carry = 1;
      ListNode curr = new ListNode(sum % 10);
      dummy.next = curr;
      dummy = dummy.next;
      l2 = l2.next;
    }
    if (carry == 1) {
      ListNode curr = new ListNode(1);
      dummy.next = curr;
      dummy = dummy.next;
    }
    return head.next;
  }
}

public class _2_Add_Two_Numbers {

  public static void main(String[] args) {
    ListNode sol = new Solution().addTwoNumbers(
      new ListNode(2, new ListNode(4, new ListNode(3))),
      new ListNode(5, new ListNode(6, new ListNode(4)))
    );
    while (sol != null) {
      System.out.println(sol.val);
      sol = sol.next;
    }
  }
}
