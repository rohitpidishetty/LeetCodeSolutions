class Solution {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if ((p == null && q != null) || (p != null && q == null)) return false;
    if (p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}

public class _100_Same_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().isSameTree(
        new TreeNode(1, new TreeNode(2), new TreeNode(3)),
        new TreeNode(1, new TreeNode(2), new TreeNode(3))
      )
    );
  }
}
