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

  private Set<String> set = new HashSet<>();

  private void solve(TreeNode r) {
    if (r == null)
      return;
    this.set.add(fn(r));
    solve(r.left);
    solve(r.right);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    solve(root);

    return this.set.contains(fn(subRoot));
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
