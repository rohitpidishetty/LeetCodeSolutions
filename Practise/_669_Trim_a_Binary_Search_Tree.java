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

  private TreeNode solve(TreeNode r, int l, int h) {
    if (r == null) return null;
    if (r.val < l) return solve(r.right, l, h);
    if (r.val > h) return solve(r.left, l, h);

    TreeNode root = r;
    root.left = solve(r.left, l, h);
    root.right = solve(r.right, l, h);
    return root;
  }

  public TreeNode trimBST(TreeNode root, int low, int high) {
    return solve(root, low, high);
  }
}

public class _669_Trim_a_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .trimBST(
          new TreeNode(
            3,
            new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)),
            new TreeNode(4)
          ),
          1,
          3
        )
    );
  }
}
