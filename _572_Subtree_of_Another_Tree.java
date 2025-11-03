import java.util.HashSet;
import java.util.Set;

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
  private String fn(TreeNode r) {
    if (r == null)
      return "";
    if (r.left == null && r.right == null)
      return String.valueOf(r.val);
    return String.valueOf(r.val) + "#" + fn(r.left) + "#" + fn(r.right);
  }

  private boolean solve(TreeNode r, String config) {
    if (r == null)
      return false;
    if (config.equals(fn(r)))
      return true;
    return solve(r.left, config) || solve(r.right, config);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    return solve(root, fn(subRoot));

  }
}

public class _572_Subtree_of_Another_Tree {
  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .isSubtree(
                new TreeNode(3,
                    new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)),
                    new TreeNode(5)),
                new TreeNode(4,
                    new TreeNode(1),
                    new TreeNode(2))));
  }
}
