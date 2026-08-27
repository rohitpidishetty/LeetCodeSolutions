import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

  Queue<Integer> q;

  public MyStack() {
    q = new ArrayDeque<>();
  }

  public void push(int x) {
    q.offer(x);
    int size = q.size();
    for (int i = 0; i < size - 1; i++) q.offer(q.poll());
  }

  public int pop() {
    return q.isEmpty() ? -1 : q.poll();
  }

  public int top() {
    return q.isEmpty() ? -1 : q.peek();
  }

  public boolean empty() {
    return q.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class _225_Implement_Stack_using_Queues {

  public static void main(String[] args) {
    MyStack s = new MyStack();
    s.push(2);
    s.push(1);
  }
}
