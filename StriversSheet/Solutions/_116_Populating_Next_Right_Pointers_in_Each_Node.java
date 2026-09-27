class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

class Solution {

  public Node connect(Node root) {
    if (root == null) return null;
    if (root.left != null) {
      root.left.next = root.right;
      if (root.next != null) root.right.next = root.next.left;
    }
    connect(root.left);
    connect(root.right);
    return root;
  }
}

public class _116_Populating_Next_Right_Pointers_in_Each_Node {

  public static void main(String[] args) {
    Node root = new Node(
      1,
      new Node(2, new Node(4), new Node(5), null),
      new Node(3, new Node(6), new Node(7), null),
      null
    );
    new Solution().connect(root);
  }
}
