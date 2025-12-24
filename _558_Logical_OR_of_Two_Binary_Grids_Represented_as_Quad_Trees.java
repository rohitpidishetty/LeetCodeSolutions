class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {
  }

  public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;
  }
}

class Solution {
  public Node intersect(Node quadTree1, Node quadTree2) {
    return null;
  }
}

public class _558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees {
  public static void main(String[] args) {
    Node res = new Solution().intersect(null, null);
  }
}
