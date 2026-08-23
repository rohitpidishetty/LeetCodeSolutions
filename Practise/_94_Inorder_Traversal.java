import java.util.ArrayList;
import java.util.List;

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

class TreeBuilder {
  public static TreeNode buildSampleTree() {
    TreeNode node6 = new TreeNode(6);
    TreeNode node9 = new TreeNode(9);
    TreeNode node7 = new TreeNode(7, null, node9);
    TreeNode node5 = new TreeNode(5, node6, node7);
    TreeNode node4 = new TreeNode(4);
    TreeNode node8 = new TreeNode(8);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(3, null, node8);
    TreeNode root = new TreeNode(1, node2, node3);
    return root;
  }
}

class Solution {
  private void callBack(TreeNode node, List<Integer> l) {
    if (node == null)
      return;
    callBack(node.left, l);
    l.add(node.val);
    callBack(node.right, l);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    callBack(root, l);
    return l;
  }
}

public class _94_Inorder_Traversal {
  public static void main(String[] args) {
    System.out.println(new Solution().inorderTraversal(TreeBuilder.buildSampleTree()));
  }
}
