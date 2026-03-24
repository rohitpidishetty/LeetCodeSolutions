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

  private TreeNode temp = null;

  private void solve(TreeNode r) {
    if (r == null) return;
    solve(r.left);
    temp.right = new TreeNode(r.val);
    temp = temp.right;
    solve(r.right);
  }

  public TreeNode increasingBST(TreeNode root) {
    TreeNode dummy = new TreeNode(-1);
    temp = dummy;
    solve(root);
    return dummy.right;
  }
}

public class _897_Increasing_Order_Search_Tree {

  public static void main(String[] args) {
    TreeNode root = new Solution().increasingBST(
      new TreeNode(
        5,
        new TreeNode(
          3,
          new TreeNode(2, new TreeNode(1), null),
          new TreeNode(4)
        ),
        new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9)))
      )
    );
    System.out.println();
    while (root != null) {
      System.out.println(root.val);
      root = root.right;
    }
  }
}
