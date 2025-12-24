import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    Set<ListNode> addre = new HashSet<>();
    while (a != null) {
      addre.add(a);
      a = a.next;
    }
    while (b != null) {
      if (addre.contains(b))
        return b;
      b = b.next;
    }
    return null;
  }
}

public class _160_Intersection_of_Two_Linked_Lists {
  public static void main(String[] args) {
    ListNode inst = new ListNode(8);
    inst.next = new ListNode(4);
    inst.next.next = new ListNode(5);
    ListNode A = new ListNode(4);
    A.next = new ListNode(1);
    A.next.next = inst;
    ListNode B = new ListNode(5);
    B.next = new ListNode(6);
    B.next.next = new ListNode(1);
    B.next.next.next = inst;
    System.out.println(new Solution().getIntersectionNode(A, B).val);

  }
}
