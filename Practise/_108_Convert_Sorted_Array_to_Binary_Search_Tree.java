
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

class Solution {
  private TreeNode buildTree(int[] nums, int l, int r) {
    if (r < l)
      return null;
    if (r == l)
      return new TreeNode(nums[r]);
    int mid = (l + r) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = buildTree(nums, l, mid - 1);
    root.right = buildTree(nums, mid + 1, r);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }
}

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
  public static void main(String[] args) {
    System.out.println(new Solution().sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
  }
}
