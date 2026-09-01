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

  private void solve(TreeNode r, List<Integer> l, List<List<Integer>> buff) {
    if (r == null) return;

    if (r.left == null && r.right == null) {
      l.add(r.data);
      buff.add(new ArrayList<>(l));
      l.remove(l.size() - 1);
      return;
    }
    l.add(r.data);
    solve(r.left, l, buff);
    solve(r.right, l, buff);
    l.remove(l.size() - 1);
  }

  public List<List<Integer>> allRootToLeaf(TreeNode root) {
    List<List<Integer>> buff = new ArrayList<>();
    solve(root, new ArrayList<>(), buff);
    return buff;
  }
}

public class _Print_root_to_leaf_path_in_BT {

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n5 = new TreeNode(5);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    n1.left = n2;
    n1.right = n3;
    n2.right = n5;
    n2.left = n4;
    System.out.println(new Solution().allRootToLeaf(n1));
  }
}
