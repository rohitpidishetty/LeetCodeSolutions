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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

  public boolean isPalindrome(ListNode head) {
    if (head == null) return false;
    if (head.next == null) return true;
    ListNode fp = head;
    ListNode sp = head;
    ListNode prev = null;
    do {
      fp = fp.next.next;
      prev = sp;
      sp = sp.next;
    } while (fp != null && fp.next != null);
    ListNode midPoint = sp;
    prev.next = null;
    // Reverse this chain
    ListNode head2 = null;
    while (midPoint != null) {
      ListNode save = midPoint.next;
      midPoint.next = head2;
      head2 = midPoint;
      midPoint = save;
    }
    while (head2 != null && head != null) {
      if (head.val != head2.val) return false;
      head2 = head2.next;
      head = head.next;
    }

    return true;
  }
}

public class _234_Palindrome_Linked_List {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .isPalindrome(new ListNode(1, new ListNode(0, new ListNode(1))))
    );
  }
}
