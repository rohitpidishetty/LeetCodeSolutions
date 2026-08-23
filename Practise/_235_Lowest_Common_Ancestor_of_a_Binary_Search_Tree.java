class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {

  private TreeNode solve(TreeNode r, TreeNode p, TreeNode q) {
    if (
      r == null || (r != null && (r.val == p.val || r.val == q.val))
    ) return r;
    TreeNode lValue = solve(r.left, p, q);
    TreeNode rValue = solve(r.right, p, q);
    if (lValue != null && rValue != null) return r;

    return lValue == null ? rValue : lValue;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == null || q == null) return null;
    return solve(root, p, q);
  }
}

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    System.out.println(
      new Solution()
        .lowestCommonAncestor(root, root.left.left, root.left.right.right)
    );
  }
}
