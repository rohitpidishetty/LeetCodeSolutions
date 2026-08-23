import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Codec {

  static class lOrder {

    protected TreeNode seed;
    protected int level;

    public lOrder(TreeNode seed, int level) {
      this.seed = seed;
      this.level = level;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<lOrder> bfs = new ArrayDeque<>();
    Map<Integer, List<String>> buffer = new HashMap<>();
    bfs.offer(new lOrder(root, 0));
    while (!bfs.isEmpty()) {
      lOrder seed = bfs.poll();
      int magnitude = buffer.size();
      while (buffer.size() <= seed.level) buffer.put(
        magnitude++,
        new ArrayList<>()
      );
      buffer.get(seed.level).add(String.valueOf(seed.seed.val));
      if (seed.seed.left != null) bfs.offer(
        new lOrder(seed.seed.left, seed.level + 1)
      );
      else {
        while (buffer.size() <= seed.level + 1) buffer.put(
          magnitude++,
          new ArrayList<>()
        );
        buffer.get(seed.level + 1).add("null");
      }
      if (seed.seed.right != null) bfs.offer(
        new lOrder(seed.seed.right, seed.level + 1)
      );
      else {
        while (buffer.size() <= seed.level + 1) buffer.put(
          magnitude++,
          new ArrayList<>()
        );
        buffer.get(seed.level + 1).add("null");
      }
    }
    StringBuilder sb = new StringBuilder();
    buffer.forEach((k, v) -> {
      v.forEach(e -> sb.append(e).append(","));
    });
    return sb.substring(0, sb.length() - 1).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("null")) return null;

    String[] nodes = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (i < nodes.length && !nodes[i].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.left);
      }
      i++;

      if (i < nodes.length && !nodes[i].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }
}

public class _297_Serialize_and_Deserialize_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.right.right.right = new TreeNode(10);
    Codec obj = new Codec();
    TreeNode deserialized = obj.deserialize(obj.serialize(root));
    System.out.println(deserialized);
  }
}
