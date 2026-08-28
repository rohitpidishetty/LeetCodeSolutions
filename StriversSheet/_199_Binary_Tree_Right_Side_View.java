import java.util.ArrayList;
import java.util.List;

class Solution {

  private void solve(TreeNode r, int level, List<Integer> buff) {
    if (r == null) return;
    solve(r.left, level + 1, buff);
    while (buff.size() <= level) buff.add(0);
    buff.set(level, r.val);
    solve(r.right, level + 1, buff);
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> buff = new ArrayList<>();
    solve(root, 0, buff);
    return buff;
  }
}

public class _199_Binary_Tree_Right_Side_View {

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
    System.out.println(new Solution().rightSideView(root));
  }
}
