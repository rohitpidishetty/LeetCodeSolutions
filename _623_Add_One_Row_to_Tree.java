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

  private void solve(TreeNode r, int v, int d, int l) {
    if (r == null) return;
    if (l == d - 1) {
      TreeNode save_left = r.left;
      TreeNode instance = new TreeNode(v);
      r.left = instance;
      instance.left = save_left;
    }
    solve(r.left, v, d, l + 1);
    if (l == d - 1) {
      TreeNode save_right = r.right;
      TreeNode instance = new TreeNode(v);
      r.right = instance;
      instance.right = save_right;
    }
    solve(r.right, v, d, l + 1);
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode instance = new TreeNode(val);
      instance.left = root;
      return instance;
    }
    int level = 1;
    solve(root, val, depth, level);
    return root;
  }
}

public class _623_Add_One_Row_to_Tree {

  public static void main(String[] args) {
    int val, depth;
    new Solution()
      .addOneRow(
        new TreeNode(
          4,
          new TreeNode(2, new TreeNode(3), new TreeNode(1)),
          new TreeNode(6, new TreeNode(5), null)
        ),
        val = 1,
        depth = 2
      );
  }
}
