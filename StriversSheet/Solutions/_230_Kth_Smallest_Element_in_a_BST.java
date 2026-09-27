class Solution {

  private int inOrder(TreeNode r, int k, int n[]) {
    if (r == null) return Integer.MAX_VALUE;

    int a = inOrder(r.left, k, n);
    if (k == n[0]++) return r.val;
    int b = inOrder(r.right, k, n);
    return Math.min(a, b);
  }

  public int kthSmallest(TreeNode root, int k) {
    int n[] = new int[] { 1 };

    return inOrder(root, k, n);
  }
}

public class _230_Kth_Smallest_Element_in_a_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution().kthSmallest(
        new TreeNode(
          3,
          new TreeNode(1, null, new TreeNode(2)),
          new TreeNode(4)
        ),
        3
      )
    );
  }
}
