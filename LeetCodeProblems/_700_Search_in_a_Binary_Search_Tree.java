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
    if (r == null) return null;
    if (v == r.val) return r;
    else if (v < r.val) return solve(r.left, v);
    else if (v > r.val) return solve(r.right, v);
    return null;
  }

  public TreeNode searchBST(TreeNode root, int val) {
    return solve(root, val);
  }
}

public class _700_Search_in_a_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .searchBST(
          new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7)
          ),
          2
        )
    );
  }
}
