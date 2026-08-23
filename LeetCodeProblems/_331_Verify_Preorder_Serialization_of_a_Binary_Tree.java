// import java.util.Stack;

// class Solution {

//   public boolean isValidSerialization(String preorder) {
//     String[] tokens = preorder.split(",");
//     Stack<String> STACK = new Stack<>();
//     int hashCount = 0;
//     for (String ch : tokens) {
//       STACK.push(ch);
//       if (ch.equals("#")) hashCount++;
//       if (hashCount == 2) {
//         int count = 3;
//         while (!STACK.isEmpty() && count-- > 0) STACK.pop();
//         STACK.push("#");
//         hashCount = 1;
//       }
//     }
//     return STACK.size() == 1 && STACK.peek().equals("#");
//   }
// }

// public class _331_Verify_Preorder_Serialization_of_a_Binary_Tree {

//   public static void main(String[] args) {
//     System.out.println(new Solution().isValidSerialization("9,#,#,1"));
//   }
// }

import java.util.Stack;

class Solution {

  public boolean isValidSerialization(String preorder) {
    String[] tokens = preorder.split(",");
    Stack<String> stack = new Stack<>();

    for (String node : tokens) {
      stack.push(node);                                                                             

      while (stack.size() >= 3) {
        int n = stack.size();
        if (
          stack.get(n - 1).equals("#") &&
          stack.get(n - 2).equals("#") &&
          !stack.get(n - 3).equals("#")
        ) {
          stack.pop();
          stack.pop();
          stack.pop();
          stack.push("#");
        } else break;
      }
    }

    return stack.size() == 1 && stack.peek().equals("#");
  }
}

public class _331_Verify_Preorder_Serialization_of_a_Binary_Tree {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    System.out.println(sol.isValidSerialization("1,#"));
    System.out.println(sol.isValidSerialization("9,#,#,1"));
  }
}
