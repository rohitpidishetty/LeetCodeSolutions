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

  private ListNode dummy;

  private void print(ListNode h) {
    while (h != null) {
      System.out.print(h.val + ", ");
      h = h.next;
    }
    System.out.println();
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode lPointer = left;
    ListNode rPointer = right;
    ListNode temp = new ListNode(Integer.MIN_VALUE);
    ListNode final_list = temp;
    while (lPointer != null && rPointer != null) {
      if (lPointer.val <= rPointer.val) {
        temp.next = lPointer;
        lPointer = lPointer.next;
      } else {
        temp.next = rPointer;
        rPointer = rPointer.next;
      }
      temp = temp.next;
    }

    if (lPointer == null) {
      while (rPointer != null) {
        temp.next = rPointer;
        rPointer = rPointer.next;
        temp = temp.next;
      }
    } else if (rPointer == null) {
      while (lPointer != null) {
        temp.next = lPointer;
        lPointer = lPointer.next;
        temp = temp.next;
      }
    }
    return final_list.next;
  }

  private ListNode solve(ListNode h) {

    if (h.next == null)
      return h;
    ListNode fp = h.next;
    ListNode sp = h;
    while (fp != null && fp.next != null) {
      sp = sp.next;
      fp = fp.next.next;
    }
    ListNode saved = sp.next;
    sp.next = null;
    ListNode left = solve(h);
    ListNode right = solve(saved);
    return merge(left, right);
  }

  public ListNode sortList(ListNode head) {
    if (head == null)
      return null;
    dummy = new ListNode(Integer.MIN_VALUE);
    ListNode solved = solve(head);
    return solved;
  }
}

public class _148_List_Merge_Sort {
  public static void main(String[] args) {
    ListNode list = new ListNode(-1,
        new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, new ListNode(-2, new ListNode(9)))))));
    new Solution().sortList(list);
  }
}