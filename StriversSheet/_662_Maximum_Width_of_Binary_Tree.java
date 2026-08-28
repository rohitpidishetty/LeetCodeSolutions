import java.util.ArrayDeque;

class Solution {

  private class Order {

    protected TreeNode node;
    protected int index;

    public Order(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

  public int widthOfBinaryTree(TreeNode root) {
    ArrayDeque<Order> q = new ArrayDeque<>();
    q.add(new Order(root, 0));
    int width = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      width = Math.max(width, q.peekLast().index - q.peekFirst().index + 1);
      while (n > 0) {
        Order r = q.poll();
        TreeNode t = r.node;
        int index = r.index;
        if (t.left != null) q.add(new Order(t.left, 2 * index + 1));
        if (t.right != null) q.add(new Order(t.right, 2 * index + 2));
        n--;
      }
    }

    return width;
  }
}

public class _662_Maximum_Width_of_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(3, new TreeNode(5), new TreeNode(3)),
      new TreeNode(2, null, new TreeNode(9))
    );
    System.out.println(new Solution().widthOfBinaryTree(root));
  }
}
