class Solution {

  private void solve(TreeNode r) {
    if (r == null) return;
    solve(r.left);
    solve(r.right);
    TreeNode left = r.left;
    TreeNode save = r.right;
    r.right = r.left;
    r.left = null;
    TreeNode head = r;
    while (head.right != null) head = head.right;
    head.right = save;
  }

  public void flatten(TreeNode root) {
    solve(root);
  }
}

public class _114_Flatten_Binary_Tree_to_Linked_List {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(3), new TreeNode(4)),
      new TreeNode(5, null, new TreeNode(6))
    );
    new Solution().flatten(root);
    while (root != null) {
      System.out.println(root.val);
      root = root.right;
    }
  }
}
