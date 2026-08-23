// class TreeNode {

//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode() {}

//   TreeNode(int val) {
//     this.val = val;
//   }

//   TreeNode(int val, TreeNode left, TreeNode right) {
//     this.val = val;
//     this.left = left;
//     this.right = right;
//   }
// }

class Solution {

  public StringBuilder solve(TreeNode r, int depth) {
    if (r == null) return null;
    if (r.left == null && r.right == null) return new StringBuilder()
      .append("(")
      .append(r.val)
      .append(")");
    StringBuilder left_tree = solve(r.left, depth + 1);
    StringBuilder right_tree = solve(r.right, depth + 1);
    return new StringBuilder()
      .append(depth != 0 ? "(" : "")
      .append(r.val)
      .append(left_tree == null ? "()" : left_tree)
      .append(right_tree == null ? "" : right_tree)
      .append(depth != 0 ? ")" : "");
  }

  public String tree2str(TreeNode root) {
    int depth;
    return (root.left == null && root.right == null)
      ? String.valueOf(root.val)
      : solve(root, depth = 0).toString();
  }
}

public class _606_Construct_String_from_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .tree2str(
          new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(4)),
            new TreeNode(3)
          )
        )
    );
  }
}
