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

  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}

public class _222_Count_Complete_Tree_Nodes {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .countNodes(
          new TreeNode(
            2,
            new TreeNode(
              10,
              new TreeNode(1, null, null),
              new TreeNode(1, null, null)
            ),
            new TreeNode(3, new TreeNode(1, null, null), null)
          )
        )
    );
  }
}
