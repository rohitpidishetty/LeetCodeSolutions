import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

  private void solve(
    TreeNode r,
    int hd,
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> vot,
    int depth
  ) {
    if (r == null) return;
    vot
      .computeIfAbsent(hd, e -> new TreeMap<>())
      .computeIfAbsent(depth, e -> new ArrayList<>())
      .add(r.val);
    solve(r.left, hd - 1, vot, depth + 1);
    solve(r.right, hd + 1, vot, depth + 1);
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> vot = new TreeMap<>();
    int depth = 0;
    solve(root, 0, vot, depth);
    List<List<Integer>> result = new ArrayList<>();
    for (Map.Entry<
      Integer,
      TreeMap<Integer, List<Integer>>
    > map : vot.entrySet()) {
      List<Integer> values = new ArrayList<>();
      for (Map.Entry<Integer, List<Integer>> m : map.getValue().entrySet()) {
        List<Integer> buffer = m.getValue();
        buffer.sort((a, b) -> a - b);
        for (int val : buffer) values.add(val);
      }
      result.add(values);
    }
    return result;
  }
}

public class _987_Vertical_Order_Traversal_of_a_Binary_Tree {

  public static void main(String[] args) {
    System.out.println(
      new Solution().verticalTraversal(
        new TreeNode(
          3,
          new TreeNode(9),
          new TreeNode(20, new TreeNode(15), new TreeNode(7))
        )
      )
    );
    System.out.println(
      new Solution().verticalTraversal(
        new TreeNode(
          1,
          new TreeNode(2, new TreeNode(4), new TreeNode(6)),
          new TreeNode(3, new TreeNode(5), new TreeNode(7))
        )
      )
    );
  }
}
