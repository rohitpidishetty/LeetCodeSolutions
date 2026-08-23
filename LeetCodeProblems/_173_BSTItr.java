import java.util.ArrayDeque;
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

class BSTIterator {
  private Queue<Integer> q;

  private void retrieve(TreeNode root) {
    if (root == null)
      return;
    retrieve(root.left);
    q.offer(root.val);
    retrieve(root.right);
  }

  public BSTIterator(TreeNode root) {
    q = new ArrayDeque<>();
    retrieve(root);
  }

  public int next() {
    return q.poll();

  }

  public boolean hasNext() {
    return !q.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class _173_BSTItr {
  public static void main(String[] args) {
    BSTIterator bSTIterator = new BSTIterator(new TreeNode(7,
        new TreeNode(3, null, null),
        new TreeNode(15,
            new TreeNode(9, null, null),
            new TreeNode(20, null, null))));

    System.out.println(bSTIterator.next()); // return 3
    System.out.println(bSTIterator.next()); // return 7
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 9
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 15
    System.out.println(bSTIterator.hasNext()); // return True
    System.out.println(bSTIterator.next()); // return 20
    System.out.println(bSTIterator.hasNext()); // return False

  }
}
