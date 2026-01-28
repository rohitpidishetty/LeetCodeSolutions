import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public int numComponents(ListNode head, int[] nums) {
    Set<Integer> numsList = new HashSet<>();
    for (int num : nums) numsList.add(num);

    boolean removed = false;
    int group = 0;
    while (head != null) {
      if (numsList.contains(head.val)) removed = true;
      else {
        if (removed) {
          group++;
          removed = false;
        }
      }
      head = head.next;
    }
    return group + (removed ? 1 : 0);
  }
}

public class _817_Linked_List_Components {

  public static void main(String[] args) {
    System.out.println(
      new Solution().numComponents(
        new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))),
        new int[] { 0, 1, 3 }
      )
    );
  }
}
