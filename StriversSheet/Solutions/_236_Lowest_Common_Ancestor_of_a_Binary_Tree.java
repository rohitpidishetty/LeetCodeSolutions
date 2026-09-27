class Solution {

  private TreeNode solve(TreeNode r, TreeNode p, TreeNode q) {
    if (r == null) return null;
    if (r.val == p.val || r.val == q.val) return r;
    TreeNode lret = solve(r.left, p, q);
    TreeNode rret = solve(r.right, p, q);
    if (lret != null && rret != null) return r;
    else if (rret == null && lret != null) return lret;
    else if (lret == null && rret != null) return rret;
    return null;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return solve(root, p, q);
  }
}

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

  public static void main(String[] args) {
    TreeNode p = new TreeNode(
      5,
      new TreeNode(6),
      new TreeNode(2, new TreeNode(7), new TreeNode(4))
    );

    TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));

    TreeNode root = new TreeNode(3, p, q);

    System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
  }
}
