import java.util.Arrays;
import java.util.Stack;

class Solution {

  /**
   * This code works for all the path's strting from a valid dir/
   */
  // public int lengthLongestPath(String input) {
  //   input = input.replaceAll("\t", "0");
  //   String[] pathTokens = input.split("\n");
  //   Stack<String> path_stack = new Stack<>();
  //   int length = 0;
  //   int retLen = Integer.MIN_VALUE;
  //   path_stack.push(pathTokens[0]);
  //   length += pathTokens[0].length();
  //   for (int i = 1; i < pathTokens.length; i++) {
  //     int j = 0;
  //     while (Character.isDigit(pathTokens[i].charAt(j))) j++;
  //     String pathDir = pathTokens[i].substring(j);
  //     length += pathDir.length();
  //     if (path_stack.size() == j) {
  //       path_stack.push(pathDir);
  //     } else {
  //       while (!path_stack.isEmpty() && path_stack.size() > j) {
  //         length -= path_stack.peek().length();
  //         path_stack.pop();
  //       }
  //       path_stack.push(pathDir);
  //     }
  //     if (path_stack.peek().endsWith(".ext")) {
  //       retLen = Math.max(retLen, length + (path_stack.size() - 1));
  //     }
  //   }
  //   return retLen == Integer.MIN_VALUE ? 0 : retLen;
  // }

  public int lengthLongestPath(String input) {
    String[] pathTokens = input.split("\n");
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int maxLen = 0;
    for (String token : pathTokens) {
      int level = 0;
      while (token.charAt(level) == '\t') level++;
      String name = token.substring(level);
      while (stack.size() > level + 1) stack.pop();
      int curLen = stack.peek() + name.length() + 1;
      stack.push(curLen);
      if (name.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
    }
    return maxLen;
  }
}

public class _388_Longest_Absolute_File_Path {

  public static void main(String[] args) {
    String path = "file1.txt\nfile2.txt\nlongfile.txt";
    System.out.println(new Solution().lengthLongestPath(path));
  }
}
