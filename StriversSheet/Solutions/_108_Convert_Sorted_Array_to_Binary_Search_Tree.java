class Solution {

  private TreeNode build(int l, int r, int[] nums) {
    if (l == r) return new TreeNode(nums[l]);
    if (l > r) return null;
    int m = (l + r) / 2;

    TreeNode root = new TreeNode(nums[m]);
    root.left = build(l, m - 1, nums);
    root.right = build(m + 1, r, nums);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return build(0, nums.length - 1, nums);
  }
}

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().sortedArrayToBST(new int[] { -10, -3, 0, 59 })
    );
  }
}
