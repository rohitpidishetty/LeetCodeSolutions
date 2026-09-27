class Solution {

  private boolean search(TreeNode r, int rem, TreeNode curr) {
    if (r == null) return false;
    if (r.val == rem) return r != curr;
    else if (rem < r.val) return search(r.left, rem, curr);
    return search(r.right, rem, curr);
  }

  private boolean solve(TreeNode r, int k, TreeNode root) {
    if (r == null) return false;
    boolean a = solve(r.left, k, root);
    boolean found = search(root, k - r.val, r);
    if (found) return true;
    boolean b = solve(r.right, k, root);
    return a || b;
  }

  public boolean findTarget(TreeNode root, int k) {
    return solve(root, k, root);
  }
}

public class _653_Two_Sum_IV__Input_is_a_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findTarget(
        new TreeNode(
          5,
          new TreeNode(3, new TreeNode(2), new TreeNode(4)),
          new TreeNode(6, null, new TreeNode(7))
        ),
        9
      )
    );
  }
}
