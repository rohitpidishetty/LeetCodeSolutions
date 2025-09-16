import java.util.Random;

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

  private ListNode temp;
  private Random rand;

  public Solution(ListNode head) {
    rand = new Random();
    temp = head;
  }

  public int getRandom() {
    ListNode t = temp;
    int count = 1;
    int result = 0;
    while (t != null) {
      if (rand.nextInt(count) == 0) result = t.val;
      count++;
      t = t.next;
    }
    return result;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
public class _382_Linked_List_Random_Node {

  public static void main(String[] args) {
    Solution obj = new Solution(
      new ListNode(1, new ListNode(2, new ListNode(3)))
    );
    System.out.println(obj.getRandom());
    System.out.println(obj.getRandom());

    System.out.println(obj.getRandom());
  }
}
