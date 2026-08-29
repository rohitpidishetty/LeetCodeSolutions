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

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Queue<Node> q = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    Map<Integer, Node> address = new HashMap<>();
    q.offer(node);
    visited.add(node.val);
    while (!q.isEmpty()) {
      Node current = q.poll();
      Node cloneNode;
      if (!address.containsKey(current.val)) {
        cloneNode = new Node(current.val);
        address.put(current.val, cloneNode);
      } else cloneNode = address.get(current.val);

      if (!current.neighbors.isEmpty()) {
        for (Node neighbor : current.neighbors) {
          if (!address.containsKey(neighbor.val)) {
            Node pointer = new Node(neighbor.val);
            address.put(neighbor.val, pointer);
          }
          cloneNode.neighbors.add(address.get(neighbor.val));
          if (visited.contains(neighbor.val)) continue;
          q.offer(neighbor);
          visited.add(neighbor.val);
        }
      }
    }

    return address.get(node.val);
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

    Node root = n1;

    Node cloned = new Solution().cloneGraph(root);

    System.out.println(cloned);
  }
}

// [[2,4],[1,3],[2,4],[1,3]]
