import java.util.Stack;
import java.util.regex.Pattern;

class Solution {
  public String simplifyPath(String path) {
    String finalPath = new String();
    Stack<String> stack = new Stack<>();
    String[] tokens = path.split("/");
    for (int i = 0; i < tokens.length; i++) {
      System.out.println(tokens[i]);
      if (Pattern.matches("([A-Za-z]+|...|.{2}+[A-Za-z$]+)", tokens[i]))
        stack.push("/" + tokens[i]);
      else if (tokens[i].equals("..") && !stack.isEmpty())
        stack.pop();
      else if (tokens[i].equals("."))
        continue;
    }
    System.out.println(stack);
    while (!stack.isEmpty())
      finalPath = stack.pop() + finalPath;
    return finalPath.length() == 0 ? "/" : finalPath;
  }
}

public class Path {
  public static void main(String[] args) {
    // System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    // System.out.println(new Solution().simplifyPath("/home/"));
    // System.out.println(new Solution().simplifyPath("/home//foo/"));
    System.out.println(new Solution().simplifyPath("/home/user/Documents/../Pictures"));
    // System.out.println(new Solution().simplifyPath("/../"));
    System.out.println(new Solution().simplifyPath("/..hidden"));

    System.out.println(Pattern.matches(".{2}+[A-Za-z$]+", "..hidden"));

  }
}
