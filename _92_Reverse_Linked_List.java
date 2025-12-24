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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head.next == null || left == right)
      return head;

    // Identify where to break the list
    int idx = 0;
    ListNode curr = head;
    ListNode prev = head;
    ListNode newList = null;
    while (curr != null) {
      if (idx == right - 1) {
        newList = curr.next;
        curr.next = null;
        break;
      }
      curr = curr.next;
      idx++;
    }

    if (left == 1) {
      ListNode travel = head;
      while (travel != null) {
        ListNode next = travel.next;
        travel.next = newList;
        newList = travel;
        travel = next;
      }
      return curr;
    }

    ListNode travel = head;
    idx = 0;
    ListNode reverseLink = null;
    while (travel != null) {
      if (idx == left - 1) {
        reverseLink = travel;
        prev.next = null;
        break;
      }
      prev = travel;
      travel = travel.next;
      idx++;
    }

    while (reverseLink != null) {
      ListNode next = reverseLink.next;
      reverseLink.next = newList;
      newList = reverseLink;
      reverseLink = next;
    }

    prev.next = newList;
    return head;
  }
}

public class _92_Reverse_Linked_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    printList(new Solution().reverseBetween(head, 1, 4));
  }

  static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val);
      if (head.next != null)
        System.out.print(" -> ");
      head = head.next;
    }
    System.out.println();
  }
}
