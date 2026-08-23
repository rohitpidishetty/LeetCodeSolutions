import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> buffer = new ArrayList<>();
    if (root == null)
      return buffer;
    Queue<TreeNode> bfsQ = new ArrayDeque<>();
    bfsQ.offer(root);
    while (!bfsQ.isEmpty()) {
      int size = bfsQ.size();
      int i = 0;
      int max = Integer.MIN_VALUE;
      while (i < size) {
        TreeNode level_queue = bfsQ.poll();
        max = Math.max(max, level_queue.val);
        if (level_queue.left != null)
          bfsQ.offer(level_queue.left);
        if (level_queue.right != null)
          bfsQ.offer(level_queue.right);
        i++;
      }
      buffer.add(max);
    }
    return buffer;
  }
}

public class _515_Find_Largest_Value_in_Each_Tree_Row {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .largestValues(
            new TreeNode(1,
                new TreeNode(3,
                    new TreeNode(5),
                    new TreeNode(3)),
                new TreeNode(2,
                    null,
                    new TreeNode(9)))));
  }
}
