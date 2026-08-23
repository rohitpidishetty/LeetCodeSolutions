import java.util.*;

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

  public List<Integer> preorder(Node root) {
    List<Integer> buffer = new ArrayList<>();
    if (root == null) return buffer;
    ArrayDeque<Node> bfsQ = new ArrayDeque<>();
    bfsQ.offer(root);

    while (!bfsQ.isEmpty()) {
      Node o = bfsQ.poll();
      buffer.add(o.val);
      if (o != null && o.children != null) {
        int n = o.children.size() - 1;
        for (int i = n; i > -1; i--) {
          bfsQ.offerFirst(o.children.get(i));
        }
      }
    }
    return buffer;
  }
}

public class _589_N_ary_Tree_Preorder_Traversal {

  public static void main(String[] args) {
    Node n14 = new Node(14);
    Node n13 = new Node(13);
    Node n12 = new Node(12);
    Node n11 = new Node(11, Arrays.asList(n14));
    Node n10 = new Node(10);
    Node n9 = new Node(9, Arrays.asList(n13));
    Node n8 = new Node(8, Arrays.asList(n12));
    Node n7 = new Node(7, Arrays.asList(n11));
    Node n6 = new Node(6);
    Node n5 = new Node(5, Arrays.asList(n9, n10));
    Node n4 = new Node(4, Arrays.asList(n8));
    Node n3 = new Node(3, Arrays.asList(n6, n7));
    Node n2 = new Node(2);
    Node n1 = new Node(1, Arrays.asList(n2, n3, n4, n5));
    System.out.println(new Solution().preorder(n1));
  }
}
