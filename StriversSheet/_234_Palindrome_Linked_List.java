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

  private ListNode reverse(ListNode head) {
    if (head == null) return null;
    ListNode prev = null;
    while (head != null) {
      ListNode save = head.next;
      head.next = prev;
      prev = head;
      head = save;
    }
    return prev;
  }

  public boolean isPalindrome(ListNode head) {
    if (head.next == null) return true;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode nextStream = reverse(slow.next);
    slow.next = null;
    while (head != null && nextStream != null) {
      if (head.val != nextStream.val) return false;
      head = head.next;
      nextStream = nextStream.next;
    }
    return true;
  }
}

public class _234_Palindrome_Linked_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(0, new ListNode(2)));
    System.out.println(new Solution().isPalindrome(head));
  }
}
