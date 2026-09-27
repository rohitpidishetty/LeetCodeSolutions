class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  private TreeNode solve(TreeNode r, TreeNode p, TreeNode q) {
    if (r == null) return r;

    if (p.val < r.val && q.val < r.val) return solve(r.left, p, q);
    if (p.val > r.val && q.val > r.val) return solve(r.right, p, q);

    return r;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return solve(root, p, q);
  }
}

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().lowestCommonAncestor(
        new TreeNode(
          6,
          new TreeNode(
            2,
            new TreeNode(0),
            new TreeNode(4, new TreeNode(3), new TreeNode(5))
          ),
          new TreeNode(8, new TreeNode(7), new TreeNode(9))
        ),
        new TreeNode(3),
        new TreeNode(5)
      ).val
    );
  }
}
