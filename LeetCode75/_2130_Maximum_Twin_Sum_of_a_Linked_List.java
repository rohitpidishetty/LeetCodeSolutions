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
    ListNode prev = null;
    while (head != null) {
      ListNode save = head.next;
      head.next = prev;
      prev = head;
      head = save;
    }
    return prev;
  }

  public int pairSum(ListNode head) {
    // Break the ll into 2
    // Reverse the second ll
    // Count for max pair sum
    // Return the max
    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;

    do {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    } while (fast != null && fast.next != null);

    ListNode second = reverse(slow);
    prev.next = null;

    while (second != null) {
      System.out.println(second.val + " <>");
      second = second.next;
    }
    int max = 0;
    while (head != null) {
      max = Math.max(max, head.val + second.val);
      head = head.next;
      second = second.next;
    }

    return max;
  }
}

public class _2130_Maximum_Twin_Sum_of_a_Linked_List {

  public static void main(String[] args) {
    System.out.println(
      new Solution().pairSum(
        new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))
      )
    );
  }
}
