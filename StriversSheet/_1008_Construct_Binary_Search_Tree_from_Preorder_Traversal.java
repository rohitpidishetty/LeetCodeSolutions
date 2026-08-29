class Solution {

  private int rootPos = 0;

  private TreeNode builder(int[] buff, int min, int max) {
    if (
      rootPos > buff.length || !(buff[rootPos] >= min && buff[rootPos] <= max)
    ) return null;

    int rootVal = buff[rootPos++];
    TreeNode root = new TreeNode(rootVal);
    root.left = builder(buff, min, rootVal);
    root.right = builder(buff, rootVal, max);
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    return builder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}

public class _1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution().bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 })
    );
  }
}
