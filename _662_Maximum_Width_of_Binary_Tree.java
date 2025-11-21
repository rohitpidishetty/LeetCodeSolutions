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

  @Override
  public String toString() {
    return String.valueOf(this.val);
  }
}

class Solution {

  // 72 / 117 testcases passed
  // private int height(TreeNode r) {
  //   if (r == null) return 0;
  //   return 1 + Math.max(height(r.left), height(r.right));
  // }

  // private void load(TreeNode[] buffer, TreeNode r, int index) {
  //   if (r == null) return;
  //   buffer[index] = r;
  //   load(buffer, r.left, (2 * index) + 1);
  //   load(buffer, r.right, (2 * index) + 2);
  // }

  // public int widthOfBinaryTree(TreeNode root) {
  //   int height = height(root);
  //   int power = 0;
  //   int magnitude = 0;
  //   int total = (1 << height) - 1;
  //   TreeNode[] obj_array = new TreeNode[total];
  //   load(obj_array, root, 0);

  //   int maxWidth = 0;
  //   int n = obj_array.length;
  //   for (int i = 0; i < height; i++) {
  //     int start = (1 << i) - 1;
  //     int end = (1 << (i + 1)) - 2;
  //     int I = start;
  //     int J = end;
  //     while (I <= J && obj_array[I] == null) I++;
  //     while (I <= J && obj_array[J] == null) J--;
  //     if (I <= J) maxWidth = Math.max(maxWidth, (J - I + 1));
  //   }
  //   return maxWidth;
  // }

  private class nodeOrder {

    protected TreeNode node;
    protected int level;

    public nodeOrder(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public int widthOfBinaryTree(TreeNode root) {
    /**
     *           1
     *         /   \
     *        3     2
     *       / \     \
     *      5   3     9
     */
    int maxWidth = 0;
    ArrayDeque<nodeOrder> bfsQ = new ArrayDeque<>();
    bfsQ.offer(new nodeOrder(root, 0));
    while (!bfsQ.isEmpty()) {
      int n = bfsQ.size();
      maxWidth = Math.max(
        maxWidth,
        bfsQ.peekLast().level - bfsQ.peekFirst().level + 1
      );
      for (int i = 0; i < n; i++) {
        nodeOrder neighbor = bfsQ.poll();
        if (neighbor.node.left != null) bfsQ.offer(
          new nodeOrder(neighbor.node.left, (2 * neighbor.level) + 1)
        );
        if (neighbor.node.right != null) bfsQ.offer(
          new nodeOrder(neighbor.node.right, (2 * neighbor.level) + 2)
        );
      }
    }
    return maxWidth;
  }
}

public class _662_Maximum_Width_of_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .widthOfBinaryTree(
          new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9))
          )
        )
    );
  }
}
