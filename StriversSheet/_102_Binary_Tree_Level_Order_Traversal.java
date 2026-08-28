import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    List<List<Integer>> res = new ArrayList<>();
    q.offer(root);
    int level = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      while (n > 0) {
        while (res.size() <= level) res.add(new ArrayList<>());
        TreeNode r = q.poll();
        res.get(level).add(r.val);
        if (r.left != null) q.offer(r.left);
        if (r.right != null) q.offer(r.right);
        n--;
      }
      level++;
    }

    return res;
  }
}

public class _102_Binary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(3, new TreeNode(5), new TreeNode(3)),
      new TreeNode(2, null, new TreeNode(9))
    );
    System.out.println(new Solution().levelOrder(root));
  }
}
