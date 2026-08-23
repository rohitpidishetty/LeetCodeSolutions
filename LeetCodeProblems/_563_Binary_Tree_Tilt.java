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

  private int ans = 0;

  public int findTilt(TreeNode root) {
    dfs(root);
    return this.ans;
  }

  private int dfs(TreeNode r) {
    if (r == null)
      return 0;
    int ls = dfs(r.left);
    int rs = dfs(r.right);
    this.ans += Math.abs(ls - rs);
    return r.val + ls + rs;
  }

  // Higher Time Complexity
  // private int ans = 0;

  // private int get(TreeNode r) {
  // if (r == null)
  // return 0;
  // return r.val + get(r.left) + get(r.right);
  // }

  // private void solve(TreeNode root) {
  // if (root == null)
  // return;
  // root.val = Math.abs(get(root.left) - get(root.right));
  // ans += root.val;
  // solve(root.left);
  // solve(root.right);
  // }

  // public int findTilt(TreeNode root) {
  // solve(root);
  // return this.ans;
  // }

}

public class _563_Binary_Tree_Tilt {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .findTilt(
            new TreeNode(21,
                new TreeNode(7,
                    new TreeNode(1,
                        new TreeNode(3),
                        new TreeNode(3)),
                    new TreeNode(1)),
                new TreeNode(14,
                    new TreeNode(2),
                    new TreeNode(2)))));
  }
}