class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int val) {
    this.val = val;
  }
}

class BinaryTree {
  public static TreeNode createTree() {
    // TreeNode root = new TreeNode(5);
    // root.left = new TreeNode(3);
    // root.right = new TreeNode(7);
    // root.left.left = new TreeNode(2);
    // root.left.right = new TreeNode(4);
    // root.right.right = new TreeNode(8);

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);

    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    // root.right.right = new TreeNode(8);

    return root;
  }
}

class Solution {
  private static boolean callBack(TreeNode node, int lowerLimit, int upperLimit) {
    if (node == null)
      return true;
    if (!(node.val > lowerLimit && node.val < upperLimit))
      return false;
    return callBack(node.left, lowerLimit, node.val) && callBack(node.right, node.val, upperLimit);
  }

  public boolean isValidBST(TreeNode root) {
    return callBack(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}

public class _98_Validate_BST {
  public static void main(String[] args) {
    System.out.println(new Solution().isValidBST(BinaryTree.createTree()));
  }
}
