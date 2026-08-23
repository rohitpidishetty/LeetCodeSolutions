import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Codec {

  private void pre_ord(TreeNode r, StringBuilder sb) {
    if (r == null) return;
    sb.append(r.val).append(",");
    pre_ord(r.left, sb);
    pre_ord(r.right, sb);
  }

  private void in_ord(TreeNode r, StringBuilder sb) {
    if (r == null) return;
    in_ord(r.left, sb);
    sb.append(r.val).append(",");
    in_ord(r.right, sb);
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    pre_ord(root, sb);
    sb.append("@");
    in_ord(root, sb);
    return sb.toString();
  }

  private int ROOT_GLOBAL_POINTER;
  private Map<String, Integer> indices;
  private String[] preords;

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() == 1) return null;
    String[] serializedBuffer = data.split("@");
    String preord[] = serializedBuffer[0].split(",");
    String inord[] = serializedBuffer[1].split(",");
    ROOT_GLOBAL_POINTER = 0;
    indices = new HashMap<>();
    preords = preord;
    int n = inord.length;
    for (int i = 0; i < n; i++) indices.put(inord[i], i);
    int left = 0, right = n - 1;
    return buildTree(left, right);
  }

  private TreeNode buildTree(int l, int r) {
    if (l > r) return null;
    String node = preords[ROOT_GLOBAL_POINTER++];
    int currEle = Integer.valueOf(node);
    int limit = indices.get(node);
    TreeNode root = new TreeNode(currEle);
    root.left = buildTree(l, limit - 1);
    root.right = buildTree(limit + 1, r);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
public class _449_Serialize_and_Deserialize_BST {

  public static void main(String[] args) {
    TreeNode root = null;
    // TreeNode root = new TreeNode(20);
    // root.left = new TreeNode(17);
    // root.right = new TreeNode(30);
    // root.left.left = new TreeNode(3);
    // root.left.right = new TreeNode(18);
    // root.left.left.left = new TreeNode(2);
    /**
     *               20
     *              /  \
     *            17    30
     *           /  \
     *          3   18
     *         /
     *        2
     */
    Codec ser = new Codec();
    Codec deser = new Codec();
    String tree = ser.serialize(root);
    System.out.println(tree);
    TreeNode deser_tree = deser.deserialize(tree);
    System.out.println(deser_tree);
  }
}
