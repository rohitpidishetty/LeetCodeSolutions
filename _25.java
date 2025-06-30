
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

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode refPoint = head;
    ListNode ret = head;
    boolean changed = false;
    ListNode store = null;
    ListNode prev = null;
    int pos = 1;
    while (head != null) {
      if (pos % k == 0) {
        ListNode makeHead = refPoint;
        ListNode nextPointer = head.next;
        ListNode currPointer = nextPointer;

        while (refPoint != nextPointer) {
          ListNode refNext = refPoint.next;
          refPoint.next = currPointer;
          currPointer = refPoint;
          refPoint = refNext;
        }

        if (prev == null)
          ret = head;
        store = prev;
        prev = makeHead;

        if (store != null)
          store.next = head;
        head = nextPointer;
        pos++;
        changed = true;

      }
      if (!changed) {
        pos++;
        head = head.next;
      }
      changed = false;
    }
    return ret;
  }
}

public class _25 {
  public static void main(String[] args) {
    ListNode head = new Solution().reverseKGroup(
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5,
                            new ListNode(6,
                                new ListNode(7,
                                    new ListNode(8)))))))),
        2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }

  }
}
