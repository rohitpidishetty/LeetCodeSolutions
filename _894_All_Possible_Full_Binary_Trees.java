import java.util.ArrayList;
import java.util.Arrays;
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

  public List<TreeNode> allPossibleFBT(int n) {
    if (n == 0) return null;
    if (n == 1) {
      TreeNode root = new TreeNode(0);
      return Arrays.asList(root);
    }
    for (int i = 1; i < n; i += 2) {
      TreeNode root = new TreeNode(0);
      List<TreeNode> leftFBT = allPossibleFBT(i);
      List<TreeNode> rightFBT = allPossibleFBT(n - i);
      List<TreeNode> result = new ArrayList<>();
      for (TreeNode l : leftFBT) {
        for (TreeNode r : rightFBT) {
          root.left = l;
          root.right = r;
          result.add(root);
        }
      }
    }
    return result;
  }
}

public class _894_All_Possible_Full_Binary_Trees {

  public static void main(String[] args) {
    System.out.println(new Solution().allPossibleFBT(7));
  }
}
