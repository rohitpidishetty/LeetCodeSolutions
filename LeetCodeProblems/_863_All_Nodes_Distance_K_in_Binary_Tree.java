import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  TreeNode(int x, TreeNode left, TreeNode right) {
    this.val = x;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    int parent;
    List<List<Integer>> graph = new ArrayList<>();
    Queue<TreeNode> bfsQ = new ArrayDeque<>();
    bfsQ.add(root);

    while (!bfsQ.isEmpty()) {
      // Neighbors of current node
      TreeNode current = bfsQ.poll();
      while (graph.size() <= current.val) graph.add(new ArrayList<>());
      if (current.left != null) {
        while (graph.size() <= current.left.val) graph.add(new ArrayList<>());
        graph.get(current.val).add(current.left.val);
        graph.get(current.left.val).add(current.val);
        bfsQ.add(current.left);
      }
      if (current.right != null) {
        while (graph.size() <= current.right.val) graph.add(new ArrayList<>());
        graph.get(current.val).add(current.right.val);
        graph.get(current.right.val).add(current.val);
        bfsQ.add(current.right);
      }
    }

    List<Integer> result = new ArrayList<>();
    Queue<Integer> levelOrderBfsQ = new ArrayDeque<>();
    levelOrderBfsQ.add(target.val);
    int level = 0;
    Set<Integer> visited = new HashSet<>();
    visited.add(target.val);
    while (!levelOrderBfsQ.isEmpty()) {
      // Neighbors
      if (level == k) {
        while (!levelOrderBfsQ.isEmpty()) result.add(levelOrderBfsQ.poll());
        return result;
      }
      int n = levelOrderBfsQ.size(),
        i = 0;
      while (i < n) {
        for (int neighbor : graph.get(levelOrderBfsQ.poll())) {
          if (!visited.contains(neighbor)) {
            levelOrderBfsQ.add(neighbor);
            visited.add(neighbor);
          }
        }
        i++;
      }
      level++;
    }

    return result;
  }
}

public class _863_All_Nodes_Distance_K_in_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().distanceK(
        new TreeNode(
          3,
          new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(2, new TreeNode(7), new TreeNode(4))
          ),
          new TreeNode(1, new TreeNode(0), new TreeNode(8))
        ),
        new TreeNode(5),
        2
      )
    );
  }
}
