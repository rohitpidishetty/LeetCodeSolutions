import java.util.Arrays;
import java.util.List;

class Node {
  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}

class Solution {
  private int solve(Node root) {
    if (root == null || root.children == null)
      return 1;
    int max = 0;
    for (Node child : root.children)
      max = Math.max(max, solve(child));
    return max + 1;
  }

  public int maxDepth(Node root) {
    return solve(root);
  }
}

public class _559_Maximum_Depth_of_N_ary_Tree {
  public static void main(String[] args) {
    Node root = new Node(1,
        Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));

    System.out.println(new Solution().maxDepth(root));
  }
}
