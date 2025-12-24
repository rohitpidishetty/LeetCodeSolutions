class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

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

  private int max = 0;

  private int solve(TreeNode r) {
    if (r == null)
      return 0;
    int ax = solve(r.left);
    int bx = solve(r.right);

    this.max = Math.max(this.max, ax + bx);
    return Math.max(ax, bx) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    solve(root);
    return this.max;
  }
}

public class _543_Diameter_of_Binary_Tree {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .diameterOfBinaryTree(
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)),
                new TreeNode(3))));
  }
}
