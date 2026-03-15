import java.util.ArrayDeque;
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

  public int widthOfBinaryTree(TreeNode root) {
    Long max = 0l;
    Long idx = 0l;
    ArrayDeque<Object[]> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new Object[] { root, idx });
    while (!bfsQ.isEmpty()) {
      int n = bfsQ.size();

      max = Math.max(
        max,
        ((Long) bfsQ.peekLast()[1]) - ((Long) bfsQ.peekFirst()[1]) + 1
      );
      while (n > 0) {
        Object[] current = bfsQ.poll();
        if (((TreeNode) current[0]).left != null) {
          bfsQ.offer(
            new Object[] {
              ((TreeNode) current[0]).left,
              2 * ((Long) current[1]) + 1,
            }
          );
        }
        if (((TreeNode) current[0]).right != null) {
          bfsQ.offer(
            new Object[] {
              ((TreeNode) current[0]).right,
              2 * ((Long) current[1]) + 2,
            }
          );
        }
        n--;
      }
    }
    return max.intValue();
  }
}

public class _662_Maximum_Width_of_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().widthOfBinaryTree(
        new TreeNode(
          1,
          new TreeNode(3, new TreeNode(5), new TreeNode(3)),
          new TreeNode(2, null, new TreeNode(9))
        )
      )
    );
  }
}
