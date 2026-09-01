class TreeNode {

  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {

  private boolean solve(TreeNode r) {
    if (r == null) return true;
    if (r.left == null && r.right == null) return true;
    int L = r.left == null ? 0 : r.left.val;
    int R = r.right == null ? 0 : r.right.val;
    if (r.val != (L + R)) return false;
    return solve(r.left) && solve(r.right);
  }

  public boolean checkChildrenSum(TreeNode root) {
    return solve(root);
  }
}

public class _Children_Sum_Property_in_Binary_Tree {

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(19);

    tn.left = new TreeNode(8);
    tn.right = new TreeNode(2);

    tn.left.left = new TreeNode(3);
    tn.left.right = new TreeNode(5);

    tn.right.right = new TreeNode(2);
    System.out.println(new Solution().checkChildrenSum(tn));
  }
}
