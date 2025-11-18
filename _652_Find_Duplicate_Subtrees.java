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

  // 150 / 175 testcases
  private Set<String> set;
  private Map<String, TreeNode> memMap;

  // private void trace(TreeNode r, StringBuilder sb) {
  //   if (r == null) return;
  //   sb.append(r.val).append("-");
  //   trace(r.left, sb);
  //   trace(r.right, sb);
  // }
  // private void solve(TreeNode r) {
  //   if (r == null) return;
  //   solve(r.left);
  //   StringBuilder ser = new StringBuilder();
  //   trace(r, ser);
  //   String key = new String(ser);
  //   this.map.put(key, this.map.getOrDefault(key, 0) + 1);
  //   this.memMap.put(key, r);
  //   solve(r.right);
  // }
  // public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
  //   this.map = new HashMap<>();
  //   this.memMap = new HashMap<>();
  //   List<TreeNode> buffer = new ArrayList<>();
  //   solve(root);
  //   for (Map.Entry<String, Integer> items : this.map.entrySet()) {
  //     if (items.getValue() > 1) buffer.add(this.memMap.get(items.getKey()));
  //   }
  //   return buffer;
  // }

  private String solve(TreeNode r, List<TreeNode> buffer) {
    if (r == null) return "#";
    String path =
      solve(r.left, buffer) + "-" + solve(r.right, buffer) + "-" + r.val;
    if (!set.contains(path) && this.memMap.containsKey(path)) {
      buffer.add(this.memMap.get(path));
      set.add(path);
    }
    this.memMap.put(path, r);
    return path;
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    this.memMap = new HashMap<>();
    this.set = new HashSet<>();
    List<TreeNode> buffer = new ArrayList<>();
    solve(root, buffer);
    return buffer;
  }
}

public class _652_Find_Duplicate_Subtrees {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findDuplicateSubtrees(
          new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(
              3,
              new TreeNode(2, new TreeNode(4), null),
              new TreeNode(4)
            )
          )
        )
    );
  }
}
