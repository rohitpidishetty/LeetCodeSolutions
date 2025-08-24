import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

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

class Node {
  TreeNode node;
  int level = 0;

  Node(TreeNode node, int level) {
    this.node = node;
    this.level = level;
  }
}

class Solution {
  private List<List<Integer>> levelOrderTraversal(TreeNode root) {
    Queue<Node> q = new ArrayDeque<>();
    List<List<Integer>> ret = new ArrayList<>();
    q.offer(new Node(root, 0));
    while (!q.isEmpty()) {
      Node n = q.poll();
      while (ret.size() <= n.level)
        ret.add(new ArrayList<>());
      ret.get(n.level).add(n.node.val);
      if (n.node.left != null)
        q.offer(new Node(n.node.left, n.level + 1));
      if (n.node.right != null)
        q.offer(new Node(n.node.right, n.level + 1));
    }
    return ret.reversed();
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    return levelOrderTraversal(root);
  }
}

public class _107_Binary_Tree_Level_Order_Traversal_II {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(new Solution().levelOrderBottom(root));
  }
}