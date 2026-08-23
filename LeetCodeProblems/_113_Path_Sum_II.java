import java.util.ArrayList;
import java.util.List;

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
  private void dfs(TreeNode root, int targetSum, List<List<Integer>> bucket, List<Integer> buc, int sum) {
    if (root == null)
      return;
    buc.add(root.val);
    sum += root.val;
    if (root.left == null && root.right == null && sum == targetSum)
      bucket.add(new ArrayList<>(buc));
    dfs(root.left, targetSum, bucket, buc, sum);
    dfs(root.right, targetSum, bucket, buc, sum);
    buc.removeLast();
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> bucket = new ArrayList<>();
    dfs(root, targetSum, bucket, new ArrayList<>(), 0);
    return bucket;
  }
}

public class _113_Path_Sum_II {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(5,
        new TreeNode(4,
            new TreeNode(11,
                new TreeNode(7),
                new TreeNode(2)),
            null),
        new TreeNode(8,
            new TreeNode(13),
            new TreeNode(4,
                new TreeNode(5),
                new TreeNode(1))));
    System.out.println(new Solution().pathSum(root, 22));
  }
}
