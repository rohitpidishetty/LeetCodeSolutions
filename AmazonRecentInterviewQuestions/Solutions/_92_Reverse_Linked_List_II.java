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

  private ListNode reverse(ListNode ln) {
    ListNode prev = null;
    ListNode temp = ln;
    while (temp != null) {
      ListNode save = temp.next;
      temp.next = prev;

      prev = temp;
      temp = save;
    }
    return prev;
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;
    int index = 1;
    ListNode prev = null;
    ListNode temp = head;
    ListNode saveHead = null;
    ListNode restHead = null;
    while (temp != null) {
      if (index == left) {
        if (prev != null) prev.next = null;
        saveHead = temp;
      } else if (index == right) {
        restHead = temp.next;
        temp.next = null;
        break;
      } else prev = temp;
      temp = temp.next;
      index++;
    }
    ListNode revList = reverse(saveHead);
    if (left == 1) {
      head = revList;
      while (revList.next != null) revList = revList.next;
      revList.next = restHead;
      return head;
    }
    temp = head;
    while (temp.next != null) temp = temp.next;
    temp.next = revList;
    while (revList.next != null) revList = revList.next;
    revList.next = restHead;
    return head;
  }
}

public class _92_Reverse_Linked_List_II {

  public static void main(String[] args) {
    ListNode ln = new Solution().reverseBetween(
      new ListNode(
        1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
      ),
      2,
      4
    );
    while (ln != null) {
      System.out.println(ln.val);
      ln = ln.next;
    }
  }
}
