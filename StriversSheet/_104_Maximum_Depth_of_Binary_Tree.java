class Solution {

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}

public class _104_Maximum_Depth_of_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(3, new TreeNode(5), new TreeNode(3)),
      new TreeNode(2, null, new TreeNode(9))
    );
    System.out.println(new Solution().maxDepth(root));
  }
}
