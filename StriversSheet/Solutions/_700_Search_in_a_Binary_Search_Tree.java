class Solution {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    if (val < root.val) return searchBST(root.left, val);
    return searchBST(root.right, val);
  }
}

public class _700_Search_in_a_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().searchBST(
        new TreeNode(
          4,
          new TreeNode(2, new TreeNode(1), new TreeNode(3)),
          new TreeNode(7)
        ),
        2
      )
    );
  }
}
