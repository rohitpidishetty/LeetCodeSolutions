import java.util.List;

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

  private void print(ListNode h) {
    while (h != null) {
      System.out.print(h.val + " ");
      h = h.next;
    }
    System.out.println();
  }

  private ListNode clean(ListNode l) {
    ListNode head = l;
    ListNode t = l;
    while (t.next.next != null)
      t = t.next;
    t.next = null;

    // print(head);
    return head;
  }

  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = new ListNode(Integer.MAX_VALUE);
    ListNode temp = head;
    while (temp != null) {
      ListNode dTrav = dummy;
      ListNode target = temp;
      ListNode cont = temp.next;
      target.next = null;
      while (dTrav != null && dTrav.next.val < target.val)
        dTrav = dTrav.next;
      ListNode saved = dTrav.next;
      dTrav.next = target;
      target.next = saved;
      temp = cont;
    }
    // print(dummy);
    return clean(dummy.next);
  }
}

public class _147_Insertion_Sort_List {
  public static void main(String[] args) {
    ListNode new_link = new Solution()
        .insertionSortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));

  }
}