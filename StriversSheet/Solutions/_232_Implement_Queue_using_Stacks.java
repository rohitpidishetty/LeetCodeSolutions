import java.util.Stack;

class MyQueue {

  private Stack<Integer> s;
  private Stack<Integer> t;

  public MyQueue() {
    s = new Stack<>();
    t = new Stack<>();
  }

  public void push(int x) {
    s.push(x);
  }

  public int pop() {
    transfer();

    return t.pop();
  }

  public int peek() {
    transfer();
    return t.peek();
  }

  private void transfer() {
    if (t.isEmpty()) {
      while (!s.isEmpty()) {
        t.push(s.pop());
      }
    }
  }

  public boolean empty() {
    transfer();
    return t.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class _232_Implement_Queue_using_Stacks {

  public static void main(String[] args) {
    MyQueue q = new MyQueue();
  }
}
