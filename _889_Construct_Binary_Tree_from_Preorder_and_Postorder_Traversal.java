import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  private int globalIndex = 0;
  Map<Integer, Integer> idx;

  private TreeNode solve(int l, int r, int[] pre, int[] post) {
    if (globalIndex >= pre.length) return null;
    TreeNode root = new TreeNode(pre[globalIndex++]);
    if (l == r || globalIndex >= pre.length) return root;

    int t = this.idx.get(pre[globalIndex]);

    root.left = solve(l, t, pre, post);
    if (t + 1 <= r - 1) root.right = solve(t + 1, r - 1, pre, post);

    return root;
  }

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    int left = 0;
    this.idx = new HashMap<>();
    int right = preorder.length - 1;
    for (int i = 0; i <= right; i++) this.idx.put(postorder[i], i);
    return solve(left, right, preorder, postorder);
  }
}

public class _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution().constructFromPrePost(
        new int[] { 20, 10, 5, 30, 25, 40 },
        new int[] { 5, 10, 25, 40, 30, 20 }
      )
    );
  }
}
