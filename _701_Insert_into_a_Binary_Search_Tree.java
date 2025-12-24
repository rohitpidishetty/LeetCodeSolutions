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

  private TreeNode solve(TreeNode r, int v) {
    if (r == null) return new TreeNode(v);
    if (v < r.val) r.left = solve(r.left, v);
    if (v > r.val) r.right = solve(r.right, v);
    return r;
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    return solve(root, val);
  }
}

public class _701_Insert_into_a_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .insertIntoBST(
          new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7)
          ),
          5
        )
    );
  }
}
