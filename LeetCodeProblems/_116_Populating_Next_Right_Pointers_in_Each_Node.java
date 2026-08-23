import java.util.HashMap;
import java.util.Map;

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

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

  private static Map<Integer, Node> conf;

  private void traversal(Node root, int level) {
    if (root == null)
      return;
    traversal(root.left, level + 1);
    if (Solution.conf.get(level) == null) {
      Solution.conf.put(level, root);
      Solution.conf.get(level).next = null;
    } else {
      Solution.conf.get(level).next = root;
      Solution.conf.put(level, root);
    }
    System.out.println(root.val + " " + level);
    traversal(root.right, level + 1);
  }

  public Node connect(Node root) {
    Solution.conf = new HashMap<>();
    traversal(root, 0);
    return root;
  }
}

public class _116_Populating_Next_Right_Pointers_in_Each_Node {
  public static void main(String[] args) {
    Node r = new Solution().connect(new Node(1,
        new Node(2,
            new Node(4, null, null, null),
            new Node(5, null, null, null),
            null),
        new Node(3,
            null,
            new Node(7, null, null, null),
            null),
        null));

  }
}
