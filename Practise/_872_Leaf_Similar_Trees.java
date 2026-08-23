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

  private void dfs(TreeNode r, List<Integer> rl) {
    if (r == null) return;
    if (r.left == null && r.right == null) rl.add(r.val);
    dfs(r.left, rl);
    dfs(r.right, rl);
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> r1Leaves = new ArrayList<>();
    List<Integer> r2Leaves = new ArrayList<>();
    dfs(root1, r1Leaves);
    dfs(root2, r2Leaves);
    return r1Leaves.equals(r2Leaves);
  }
}

public class _872_Leaf_Similar_Trees {

  public static void main(String[] args) {
    System.out.println(
      new Solution().leafSimilar(
        new TreeNode(
          3,
          new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(2, new TreeNode(7), new TreeNode(4))
          ),
          new TreeNode(1, new TreeNode(9), new TreeNode(8))
        ),
        new TreeNode(
          3,
          new TreeNode(5, new TreeNode(6), new TreeNode(7)),
          new TreeNode(
            1,
            new TreeNode(4),
            new TreeNode(2, new TreeNode(9), new TreeNode(8))
          )
        )
      )
    );
  }
}
