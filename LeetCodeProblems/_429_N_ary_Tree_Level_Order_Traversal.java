import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Node {

  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}

class Solution {

  public List<List<Integer>> levelOrder(Node root) {
    Queue<Node> bfs = new ArrayDeque<>();
    bfs.offer(root);
    int idx = 0;
    List<List<Integer>> buffer = new ArrayList<>();
    while (!bfs.isEmpty()) {
      int i = 0;
      int n = bfs.size();
      while (i < n) {
        Node node = bfs.poll();
        if (node != null) {
          while (idx >= buffer.size()) buffer.add(new ArrayList<>());
          buffer.get(idx).add(node.val);
          if (node.children != null) {
            for (Node child : node.children) bfs.offer(child);
          }
          i++;
        }
      }
      idx++;
    }
    return buffer;
  }
}

public class _429_N_ary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .levelOrder(
          new Node(
            1,
            Arrays.asList(
              new Node(3, Arrays.asList(new Node(5), new Node(6))),
              new Node(2),
              new Node(4)
            )
          )
        )
    );
  }
}
