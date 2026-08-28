import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

  private void solve(
    TreeNode r,
    int order,
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map,
    int height
  ) {
    if (r == null) return;
    solve(r.left, order - 1, map, height + 1);

    map
      .computeIfAbsent(height, key -> new TreeMap<>())
      .computeIfAbsent(order, key -> new ArrayList<>())
      .add(r.val);

    solve(r.right, order + 1, map, height + 1);
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
    solve(root, 0, map, 0);

    TreeMap<Integer, List<Integer>> buff = new TreeMap<>();
    for (Map.Entry<
      Integer,
      TreeMap<Integer, List<Integer>>
    > m : map.entrySet()) {
      for (Map.Entry<Integer, List<Integer>> m1 : m.getValue().entrySet()) {
        Collections.sort(m1.getValue());
        buff
          .computeIfAbsent(m1.getKey(), key -> new ArrayList<>())
          .addAll(m1.getValue());
      }
    }
    return new ArrayList<>(buff.values());
  }
}

public class _987_Vertical_Order_Traversal_of_a_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3, new TreeNode(6), new TreeNode(7))
    );
    System.out.println(new Solution().verticalTraversal(root));
  }
}
