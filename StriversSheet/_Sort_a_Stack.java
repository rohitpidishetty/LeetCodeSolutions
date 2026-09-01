import java.util.Stack;

class Solution {

  private Integer solve(Stack<Integer> st) {
    if (st.isEmpty()) return null;
    Integer top = st.pop();
    solve(st);

    Stack<Integer> temp = new Stack<>();
    if (st.isEmpty()) st.push(top);
    else {
      while (!st.isEmpty() && st.peek() < top) temp.push(st.pop());
      st.push(top);
      while (!temp.isEmpty()) st.push(temp.pop());
    }

    return top;
  }

  public void sortStack(Stack<Integer> st) {
    solve(st);
    System.out.println(st);
    return;
  }
}

public class _Sort_a_Stack {

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(4);
    st.push(1);
    st.push(3);
    st.push(2);
    new Solution().sortStack(st);
  }
}
