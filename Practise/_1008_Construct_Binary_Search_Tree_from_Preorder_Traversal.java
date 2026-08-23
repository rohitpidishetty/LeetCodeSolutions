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

  private int[] rootOrder;
  private int[] rootIndex = new int[] { 0 };

  private TreeNode solve(int l, int r) {
    if (
      rootIndex[0] >= rootOrder.length || rootOrder[rootIndex[0]] > r
    ) return null;

    int current = rootOrder[rootIndex[0]++];

    TreeNode root = new TreeNode(current);
    root.left = solve(l, current);
    root.right = solve(current, r);

    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    rootOrder = preorder;

    return solve(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}

public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution().bstFromPreorder(
        new int[] { 8, 5, 1, 7, 10, 12 }
      ).left.right.val
    );
  }
}
