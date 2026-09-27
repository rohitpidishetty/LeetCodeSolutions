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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    if (head.next == null || k <= 0) return head;
    ListNode list = head;
    ListNode root = head;
    int len = 0;
    while (list != null) {
      len++;
      list = list.next;
    }
    k = k % len;
    if (k == 0) return head;

    int breakingPoint = len - k;
    list = head;
    int pos = 1;
    while (list != null) {
      if (pos == breakingPoint) {
        ListNode save = list.next;
        ListNode ret = save;
        list.next = null;
        while (save.next != null) save = save.next;
        save.next = root;
        return ret;
      }
      pos++;
      list = list.next;
    }
    return null;
  }
}

public class _61_Rotate_List {

  public static void main(String[] args) {
    ListNode head = new ListNode(
      1,
      new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
    );
    head = new Solution().rotateRight(head, 2);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
