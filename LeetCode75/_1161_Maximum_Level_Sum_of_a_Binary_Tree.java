import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>();
    int max = Integer.MIN_VALUE;
    int res = 0;

    q.offer(root);
    int level = 0;

    while (!q.isEmpty()) {
      int n = q.size();

      int sum = 0;
      while (n > 0) {
        TreeNode curr = q.poll();
        sum += curr.val;
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
        n--;
      }

      if (max < sum) {
        max = sum;
        res = level + 1;
      }

      level++;
    }

    return res;
  }
}

public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().maxLevelSum(
        new TreeNode(
          1,
          new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
          new TreeNode(0)
        )
      )
    );
  }
}
