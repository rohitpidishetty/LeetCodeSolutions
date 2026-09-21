import java.util.ArrayList;
import java.util.List;

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

  private boolean traverse(TreeNode r, List<Integer> leaves, boolean operate) {
    if (r == null) return true;
    if (r.left == null && r.right == null) {
      if (!operate) leaves.add(r.val);
      else {
        if (leaves.size() > 0 && leaves.getFirst() != r.val) return false;
        if (leaves.size() > 0) leaves.removeFirst();
        else return false;
      }

      return true;
    }
    return (
      traverse(r.left, leaves, operate) && traverse(r.right, leaves, operate)
    );
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> r1Leaves = new ArrayList<>();
    traverse(root1, r1Leaves, false);

    return traverse(root2, r1Leaves, true) && r1Leaves.size() == 0;
  }
}

public class _872_Leaf_Similar_Trees {

  public static void main(String[] args) {
    System.out.println(
      new Solution().leafSimilar(
        new TreeNode(
          3,
          new TreeNode(
            5,
            new TreeNode(6),
            new TreeNode(2, new TreeNode(7), new TreeNode(4))
          ),
          new TreeNode(1, new TreeNode(9), new TreeNode(8))
        ),
        new TreeNode(
          3,
          new TreeNode(5, new TreeNode(6), new TreeNode(7)),
          new TreeNode(
            1,
            new TreeNode(4),
            new TreeNode(2, new TreeNode(9), new TreeNode(8))
          )
        )
      )
    );
  }
}
