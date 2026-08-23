import java.util.*;

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

  private int height(TreeNode r) {
    if (r == null) return -1;
    return Math.max(height(r.left), height(r.right)) + 1;
  }

  private void solve(
    int row,
    int col,
    int height,
    List<List<String>> matrix,
    TreeNode root
  ) {
    if (root == null) return;
    matrix.get(row).set(col, String.valueOf(root.val));
    int offset = (int) Math.pow(2, height - row - 1);
    if (root.left != null) solve(
      row + 1,
      col - offset,
      height,
      matrix,
      root.left
    );
    if (root.right != null) solve(
      row + 1,
      col + offset,
      height,
      matrix,
      root.right
    );
  }

  public List<List<String>> printTree(TreeNode root) {
    int height = height(root);
    int MATRIX_HEIGHT = height + 1;
    int MATRIX_COLUMN = (int) (Math.pow(2, MATRIX_HEIGHT) - 1);
    List<List<String>> matrix = new ArrayList<>();
    for (int i = 0; i < MATRIX_HEIGHT; i++) {
      List<String> buffer = new ArrayList<>();
      for (int j = 0; j < MATRIX_COLUMN; j++) buffer.add("");
      matrix.add(buffer);
    }
    int row = 0, col = (MATRIX_COLUMN - 1) / 2;
    solve(row, col, height, matrix, root);
    return matrix;
  }
}

public class _655_Print_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .printTree(
          new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(4)),
            new TreeNode(3)
          )
        )
    );
  }
}
