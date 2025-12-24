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

  private void solve(TreeNode root, List<String> sb, List<String> path) {
    if (root == null) return;
    path.add(String.valueOf(root.val));
    if (root.left == null && root.right == null) {
      StringBuilder _path_ = new StringBuilder();
      int i = 0;
      int n = path.size() - 1;
      while (i < n) _path_.append(path.get(i++)).append("->");
      _path_.append(path.get(i));
      sb.add(_path_.toString());
    }
    solve(root.left, sb, path);
    solve(root.right, sb, path);
    path.remove(path.size() - 1);
  }

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return null;
    List<String> buffer = new ArrayList<>();
    solve(root, buffer, new ArrayList<>());
    return buffer;
  }
}

public class _257_Binary_Tree_Paths {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .binaryTreePaths(
          new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(5, null, null)),
            new TreeNode(3, null, null)
          )
        )
    );
  }
}
