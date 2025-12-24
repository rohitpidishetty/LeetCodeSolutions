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
  private TreeNode prev = null;

  private void rec(TreeNode root) {
    if (root == null)
      return;
    rec(root.right);
    rec(root.left);

    root.right = prev;
    prev = root;
    root.left = null;
  }

  public void flatten(TreeNode root) {
    rec(root);
  }
}

public class _114_Flatten_Binary_Tree_to_Linked_List {
  public static void main(String[] args) {
    new Solution().flatten(new TreeNode(1,
        new TreeNode(2,
            new TreeNode(3),
            new TreeNode(4)),
        new TreeNode(5,
            null,
            new TreeNode(6))));
  }
}
