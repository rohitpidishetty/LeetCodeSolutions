import java.util.Stack;

class MinStack {

  private static class MinStackElement {

    int currentStackTop, minStackElement;

    public MinStackElement(int ele, int min) {
      currentStackTop = ele;
      minStackElement = min;
    }
  }

  private Stack<MinStack.MinStackElement> s;

  public MinStack() {
    s = new Stack<>();
  }

  public void push(int value) {
    if (s.isEmpty()) {
      s.push(new MinStack.MinStackElement(value, value));
      return;
    }
    s.push(
      new MinStack.MinStackElement(
        value,
        Math.min(s.peek().minStackElement, value)
      )
    );
  }

  public void pop() {
    if (s.isEmpty()) return;
    s.pop();
  }

  public int top() {
    if (s.isEmpty()) return -1;
    return s.peek().currentStackTop;
  }

  public int getMin() {
    if (s.isEmpty()) return -1;
    return s.peek().minStackElement;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class _155_Min_Stack {

  public static void main(String[] args) {}
}
