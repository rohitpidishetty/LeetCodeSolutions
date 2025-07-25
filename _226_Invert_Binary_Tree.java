class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

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

  private TreeNode solve(TreeNode root) {
    if (root == null) return root;
    TreeNode lt = solve(root.left);
    TreeNode rt = solve(root.right);
    root.left = rt;
    root.right = lt;
    return root;
  }

  public TreeNode invertTree(TreeNode root) {
    return solve(root);
  }
}

public class _226_Invert_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new Solution()
      .invertTree(
        new TreeNode(
          4,
          new TreeNode(
            2,
            new TreeNode(1, null, null),
            new TreeNode(3, null, null)
          ),
          new TreeNode(
            7,
            new TreeNode(6, null, null),
            new TreeNode(9, null, null)
          )
        )
      );
    System.out.println(root.val);
    System.out.println(root.left.val);
  }
}
