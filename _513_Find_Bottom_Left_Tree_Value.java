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
  private int max_level = 0;
  private int max_ele = 0;

  private void dfs(TreeNode root, int level) {
    if (root == null)
      return;
    if (root.left == null && root.right == null && level > max_level) {
      max_level = level;
      max_ele = root.val;
    }
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }

  public int findBottomLeftValue(TreeNode root) {
    if (root.left == null && root.right == null)
      return root.val;
    dfs(root, 0);
    return this.max_ele;
  }
}

public class _513_Find_Bottom_Left_Tree_Value {
  public static void main(String[] args) {

    System.out.println(new Solution()
        .findBottomLeftValue(
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4), null),
                new TreeNode(3,
                    new TreeNode(5,
                        new TreeNode(7), new TreeNode(9)),
                    new TreeNode(6)))));
  }
}
