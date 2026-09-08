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

  private int sum = 0;

  private int solve(TreeNode r) {
    if (r == null) return 0;

    solve(r.right);
    sum += r.val;
    r.val = sum;
    solve(r.left);

    return sum;
  }

  public TreeNode bstToGst(TreeNode root) {
    solve(root);
    return root;
  }
}

public class _1038_Binary_Search_Tree_to_Greater_Sum_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().bstToGst(
        new TreeNode(
          4,
          new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(2, null, new TreeNode(3))
          ),
          new TreeNode(
            6,
            new TreeNode(5),
            new TreeNode(7, null, new TreeNode(8))
          )
        )
      )
    );
  }
}
