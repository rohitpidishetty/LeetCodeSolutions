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
    Set<ListNode> addresses = new HashSet<>();
    while (headA != null) {
      addresses.add(headA);
      headA = headA.next;
    }
    while (headB != null) {
      if (addresses.contains(headB)) return headB;
      headB = headB.next;
    }
    return null;
  }
}

public class _160_Intersection_of_Two_Linked_Lists {

  public static void main(String[] args) {
    System.out.println(new Solution().getIntersectionNode(null, null).val);
  }
}
