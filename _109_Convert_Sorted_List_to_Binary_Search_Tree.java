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

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  private TreeNode buildTree(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return new TreeNode(head.val);
    ListNode fp = head.next.next;
    ListNode sp = head.next;
    ListNode prev = head;
    while (fp != null && fp.next != null) {
      prev = sp;
      sp = sp.next;
      fp = fp.next.next;
    }
    TreeNode root = new TreeNode(sp.val);
    prev.next = null;
    root.left = buildTree(head);
    root.right = buildTree(sp.next);
    return root;
  }

  public TreeNode sortedListToBST(ListNode head) {
    return buildTree(head);
  }
}

public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
  public static void main(String[] args) {
    ListNode head = new ListNode(-10);
    head.next = new ListNode(-3);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(9);
    System.out.println(new Solution().sortedListToBST(head));
  }
}