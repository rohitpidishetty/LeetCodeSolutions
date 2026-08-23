import java.util.*;

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

  private void solve(TreeNode root, List<Integer> buffer) {
    if (root == null) return;
    solve(root.left, buffer);
    buffer.add(root.val);
    solve(root.right, buffer);
  }

  public boolean findTarget(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    solve(root, list);
    int i = 0, j = list.size() - 1;
    while (i < j) {
      int I = list.get(i), J = list.get(j);
      if (I + J == k) return true;
      if (I + J < k) i++;
      else j--;
    }
    return false;
  }
}

public class _653_Two_Sum_IV_Input_is_a_BST {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findTarget(
          new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7))
          ),
          9
        )
    );
  }
}
