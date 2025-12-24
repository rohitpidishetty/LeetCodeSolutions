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

  private TreeNode build(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) return null;
    TreeNode new_tree = new TreeNode(
      ((r1 == null) ? 0 : r1.val) + ((r2 == null) ? 0 : r2.val)
    );
    new_tree.left = build(
      ((r1 == null) ? null : r1.left),
      ((r2 == null) ? null : r2.left)
    );
    new_tree.right = build(
      ((r1 == null) ? null : r1.right),
      ((r2 == null) ? null : r2.right)
    );
    return new_tree;
  }

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    return build(root1, root2);
  }
}

public class _617_Merge_Two_Binary_Trees {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .mergeTrees(
          new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), null),
            new TreeNode(2)
          ),
          new TreeNode(
            2,
            new TreeNode(1, null, new TreeNode(4)),
            new TreeNode(3, null, new TreeNode(7))
          )
        )
    );
  }
}
