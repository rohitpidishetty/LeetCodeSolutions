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

// 50 / 60 testcases passed
// class Solution {

//   private int max_depth = 0;
//   private TreeNode subRoot = null;

//   private void dfs(TreeNode r, TreeNode introducer, int depth) {
//     if (r == null) return;
//     dfs(r.left, r, depth + 1);
//     dfs(r.right, r, depth + 1);
//     if (depth > max_depth) {
//       max_depth = depth;
//       subRoot = introducer;
//     }
//   }

//   public TreeNode subtreeWithAllDeepest(TreeNode root) {
//     dfs(root, null, 0);
//     return subRoot == null
//       ? root
//       : (subRoot.left == null
//           ? subRoot.right
//           : subRoot.right == null
//             ? subRoot.left
//             : subRoot);
//   }
// }

class Solution {

  private class Wrapper {

    private int depth;
    private TreeNode root;

    public Wrapper(int depth, TreeNode root) {
      this.depth = depth;
      this.root = root;
    }
  }

  private Wrapper dfs(TreeNode root) {
    if (root == null) return new Wrapper(0, null);
    Wrapper left = dfs(root.left);
    Wrapper right = dfs(root.right);
    if (left.depth == right.depth) return new Wrapper(left.depth + 1, root);
    else if (left.depth > right.depth) {
      return new Wrapper(left.depth + 1, left.root);
    } else return new Wrapper(right.depth + 1, right.root);
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return dfs(root).root;
  }
}

public class _865_Smallest_Subtree_with_all_the_Deepest_Nodes {

  public static void main(String[] args) {
    System.out.println(
      new Solution().subtreeWithAllDeepest(
        new TreeNode(
          3,
          new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(2, new TreeNode(7), new TreeNode(4))
          ),
          new TreeNode(1, new TreeNode(0), new TreeNode(8))
        )
      )
    );
  }
}
