import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayDeque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    boolean flip = false;
    TreeNode t;
    List<List<Integer>> ans = new ArrayList<>();
    int level = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      List<Integer> buffer = new ArrayList<>();
      while (n > 0) {
        t = q.poll();
        if (flip) buffer.addLast(t.val);
        else buffer.addFirst(t.val);
        if (t.left != null) q.offer(t.left);
        if (t.right != null) q.offer(t.right);
        n--;
      }
      while (ans.size() <= level) ans.add(new ArrayList<>());
      ans.get(level).addAll(buffer);
      flip = !flip;
      level++;
    }
    return ans;
  }
}

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution().zigzagLevelOrder(
        new TreeNode(
          3,
          new TreeNode(9),
          new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
      )
    );
  }
}
