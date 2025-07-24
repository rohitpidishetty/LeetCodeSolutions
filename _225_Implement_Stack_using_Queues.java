import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {

  private Queue<Integer> bufferMain;
  private Queue<Integer> tempBuffer;

  public MyStack() {
    bufferMain = new ArrayDeque<>();
    tempBuffer = new ArrayDeque<>();
  }

  public void push(int x) {
    bufferMain.offer(x);
  }

  public int pop() {
    tempBuffer = new ArrayDeque<>();
    while (bufferMain.size() > 1) {
      int ele = bufferMain.peek();
      tempBuffer.offer(ele);
      bufferMain.poll();
    }
    int ret = bufferMain.poll();
    bufferMain = tempBuffer;
    return ret;
  }

  public int top() {
    tempBuffer = new ArrayDeque<>();
    while (bufferMain.size() > 1) {
      int ele = bufferMain.peek();
      tempBuffer.offer(ele);
      bufferMain.poll();
    }
    int ret = bufferMain.poll();
    tempBuffer.offer(ret);
    bufferMain = tempBuffer;
    return ret;
  }

  public boolean empty() {
    return bufferMain.isEmpty();
  }
}

public class _225_Implement_Stack_using_Queues {

  public static void main(String[] args) {
    MyStack ms = new MyStack();
    ms.push(1);
    ms.push(2);
    ms.push(3);
    ms.push(4);
    System.out.println(ms.top());
    System.out.println(ms.pop());
    System.out.println(ms.top());
  }
}
