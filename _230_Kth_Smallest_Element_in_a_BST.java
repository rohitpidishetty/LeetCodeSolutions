import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
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

  private void solve(TreeNode root, int k, Queue<Integer> pQ) {
    if (root == null) return;
    solve(root.left, k, pQ);
    if (pQ.size() < k) pQ.add(root.val);
    else return;
    solve(root.right, k, pQ);
  }

  public int kthSmallest(TreeNode root, int k) {
    Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    solve(root, k, pQ);
    return pQ.poll();
  }
}

public class _230_Kth_Smallest_Element_in_a_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .kthSmallest(
          new TreeNode(
            5,
            new TreeNode(
              3,
              new TreeNode(2, new TreeNode(1, null, null), null),
              new TreeNode(4, null, null)
            ),
            new TreeNode(6, null, null)
          ),
          3
        )
    );
  }
}
