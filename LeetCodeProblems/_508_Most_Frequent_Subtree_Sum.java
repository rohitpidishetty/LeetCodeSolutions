import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

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
  private int subTreeSum(TreeNode r) {
    if (r == null)
      return 0;
    if (r.left == null && r.right == null)
      return r.val;
    return r.val + subTreeSum(r.left) + subTreeSum(r.right);
  }

  private void subTree(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    subTree(root.left, list);
    list.add(subTreeSum(root));
    subTree(root.right, list);
  }

  public int[] findFrequentTreeSum(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    subTree(root, list);
    list.sort((a, b) -> a - b);
    int currNum = 0, currFreq = 0, maxFreq = 0;
    List<Integer> buffer = new ArrayList<>();
    for (Integer num : list) {
      if (num != currNum) {
        currFreq = 1;
        currNum = num;
      } else
        currFreq++;
      if (currFreq > maxFreq) {
        buffer.clear();
        maxFreq = currFreq;
        buffer.add(num);
      } else if (currFreq == maxFreq)
        buffer.add(num);
    }
    return buffer.stream().mapToInt(i -> i).toArray();
  }
}

public class _508_Most_Frequent_Subtree_Sum {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new Solution().findFrequentTreeSum(new TreeNode(5, new TreeNode(2, new TreeNode(4), new TreeNode(6)),
                new TreeNode(-3, new TreeNode(-2), new TreeNode(3))))));
  }
}
