import java.util.ArrayList;
import java.util.List;

class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    data = val;
    left = null;
    right = null;
  }
}

class Solution {

  public List<Integer> floorCeilOfBST(TreeNode root, int key) {
    List<Integer> ans = new ArrayList<>();

    int floor = -1;
    int ceil = -1;
    while (root != null) {
      if (root.data == key) {
        floor = root.data;
        ceil = root.data;
        break;
      }

      if (key < root.data) {
        ceil = root.data;
        root = root.left;
      } else {
        floor = root.data;
        root = root.right;
      }
    }
    ans.add(floor);
    ans.add(ceil);

    return ans;
  }
}

public class _Floor_and_Ceil_in_a_BST {

  public static void main(String[] args) {
    TreeNode tn = new TreeNode(8);
    tn.left = new TreeNode(4);
    tn.right = new TreeNode(12);
    tn.left.left = new TreeNode(2);
    tn.left.right = new TreeNode(6);
    tn.right.left = new TreeNode(10);
    tn.right.right = new TreeNode(14);

    System.out.println(new Solution().floorCeilOfBST(tn, 11));
  }
}
