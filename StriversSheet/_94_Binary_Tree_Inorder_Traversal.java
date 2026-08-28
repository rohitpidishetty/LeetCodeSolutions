import java.util.ArrayList;
import java.util.List;

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

  private void solve(TreeNode r, List<Integer> buff) {
    if (r == null) return;
    solve(r.left, buff);
    buff.add(r.val);
    solve(r.right, buff);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> buff = new ArrayList<>();
    solve(root, buff);
    return buff;
  }
}

public class _94_Binary_Tree_Inorder_Traversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(
        2,
        new TreeNode(4),
        new TreeNode(5, new TreeNode(6), new TreeNode(7))
      ),
      new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null))
    );
    System.out.println(new Solution().inorderTraversal(root));
  }
}
