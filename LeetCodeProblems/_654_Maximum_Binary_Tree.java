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

  private TreeNode solve(int left, int right, int[] nums) {
    if (left > right) return null;
    int mid = 0;
    int max = Integer.MIN_VALUE;
    for (int i = left; i <= right; i++) {
      int n = nums[i];
      if (n > max) {
        max = n;
        mid = i;
      }
    }
    TreeNode tree = new TreeNode(nums[mid]);
    tree.left = solve(left, mid - 1, nums);
    tree.right = solve(mid + 1, right, nums);
    return tree;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return solve(0, nums.length - 1, nums);
  }
}

public class _654_Maximum_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 })
    );
  }
}
