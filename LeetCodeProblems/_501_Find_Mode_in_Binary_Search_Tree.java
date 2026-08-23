import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  private int currentNumber = 0, currentCount = 0, maxCount = 0;
  private List<Integer> buff;

  private void solve(TreeNode r) {
    if (r == null)
      return;
    solve(r.left);
    if (currentNumber != r.val) {
      currentNumber = r.val;
      currentCount = 1;
    } else {
      currentCount++;
    }
    if (currentCount > maxCount) {
      buff.clear();
      maxCount = currentCount;
      buff.add(r.val);
    } else if (currentCount == maxCount) {
      buff.add(r.val);
    }

    solve(r.right);
  }

  public int[] findMode(TreeNode root) {
    this.buff = new ArrayList<>();
    solve(root);
    return this.buff.stream().mapToInt(i -> i).toArray();
  }
}

public class _501_Find_Mode_in_Binary_Search_Tree {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new Solution()
            .findMode(
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4, null,
                            new TreeNode(4)))))));
  }
}
