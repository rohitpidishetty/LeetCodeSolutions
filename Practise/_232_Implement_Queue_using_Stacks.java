import java.util.Stack;

class MyQueue {

  private Stack<Integer> buffer;

  public MyQueue() {
    buffer = new Stack<>();
  }

  public void push(int x) {
    buffer.push(x);
  }

  public int pop() {
    Stack<Integer> tempStack = new Stack<>();
    int top = -1;
    while (buffer.size() > 1) tempStack.push(buffer.pop());
    top = buffer.pop();

    while (!tempStack.isEmpty()) buffer.push(tempStack.pop());
    return top;
  }

  public int peek() {
    Stack<Integer> tempStack = new Stack<>();
    int top = -1;
    while (buffer.size() > 1) tempStack.push(buffer.pop());
    top = buffer.pop();
    tempStack.push(top);
    while (!tempStack.isEmpty()) buffer.push(tempStack.pop());
    return top;
  }

  public boolean empty() {
    return buffer.isEmpty();
  }
}

public class _232_Implement_Queue_using_Stacks {

  public static void main(String[] args) {
    MyQueue q = new MyQueue();
    // <- 10, 20, 30, 40 <- (queue)
    q.push(10);
    q.push(20);
    q.push(30);
    q.push(40);
    q.pop();
    System.out.println(q.peek());
  }
}
