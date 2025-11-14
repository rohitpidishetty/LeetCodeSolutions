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

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> bfsQ = new ArrayDeque<>();
    List<Double> result = new ArrayList<>();
    bfsQ.offer(root);
    while (!bfsQ.isEmpty()) {
      int n = bfsQ.size();
      long sum = 0;
      for (int i = 0; i < n; i++) {
        TreeNode node = bfsQ.poll();
        sum += node.val;
        if (node.left != null) bfsQ.offer(node.left);
        if (node.right != null) bfsQ.offer(node.right);
      }
      result.add((double) sum / (double) n);
    }
    return result;
  }
}

public class _637_Average_of_Levels_in_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .averageOfLevels(
          new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7))
          )
        )
    );
  }
}
