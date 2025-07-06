import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  private Map<Integer, Node> new_nodes = new HashMap<>();

  private Map<Integer, List<Integer>> bfs(Node node) {
    Map<Integer, List<Integer>> graphConfig = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    Queue<Node> n = new ArrayDeque<>();
    n.offer(node);
    visited.add(node);
    while (!n.isEmpty()) {
      Node nq = n.poll();
      new_nodes.put(nq.val, new Node(nq.val));
      List<Node> neighbors = nq.neighbors;
      List<Integer> neis = new ArrayList<>();
      int i = 0;
      int m = neighbors.size();
      while (i < m) {
        Node neighbor = neighbors.get(i);
        if (!visited.contains(neighbor)) {
          n.add(neighbor);
          visited.add(neighbor);
        }
        neis.add(neighbor.val);
        i++;
      }
      graphConfig.put(nq.val, neis);
    }
    return graphConfig;
  }

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;
    if (node.neighbors == null)
      return node;
    Map<Integer, List<Integer>> config = bfs(node);
    Node[] newNode = new Node[1];
    config.forEach((k, v) -> {
      int n = v.size();
      int i = 0;
      while (i < n) {
        new_nodes.get(k).neighbors.add(new_nodes.get(v.get(i)));
        if (newNode[0] == null)
          newNode[0] = new_nodes.get(k);
        i++;
      }
    });
    return newNode[0];
  }
}

public class _133_Clone_Graph {
  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    n1.neighbors.add(n2);
    n1.neighbors.add(n4);
    n2.neighbors.add(n1);
    n2.neighbors.add(n3);
    n3.neighbors.add(n2);
    n3.neighbors.add(n4);
    n4.neighbors.add(n1);
    n4.neighbors.add(n3);
    Node newGraph = new Solution().cloneGraph(n1);

    System.out.println(newGraph.neighbors);
  }

}
