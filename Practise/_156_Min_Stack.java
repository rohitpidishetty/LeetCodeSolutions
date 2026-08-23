class MinStack {
  static class Node {
    int value;
    Node next;
    Node previous;

    public Node() {
    }

    public Node(int val) {
      this.value = val;
    }
  }

  private Node baseAddr;
  private Node topAddr;
  private Node minElebaseAddr = null;
  private Node minEletopAddr = null;

  public MinStack() {
    baseAddr = new Node(Integer.MIN_VALUE);
    topAddr = baseAddr;

  }

  public void push(int val) {
    Node prev = topAddr;
    if (minEletopAddr == null || val <= minEletopAddr.value) {
      Node minNode = new Node(val);
      minNode.previous = minEletopAddr;
      if (minEletopAddr != null)
        minEletopAddr.next = minNode;
      minEletopAddr = minNode;
      if (minElebaseAddr == null)
        minElebaseAddr = minNode;
    }
    Node NEXT = new Node(val);
    topAddr.next = NEXT;
    topAddr = NEXT;
    topAddr.previous = prev;

  }

  public void pop() {
    if (topAddr == baseAddr)
      return;
    int val = topAddr.value;
    topAddr = topAddr.previous;
    topAddr.next = null;
    if (minEletopAddr != null && minEletopAddr.value == val) {
      Node prevMin = minEletopAddr.previous;
      if (prevMin != null) {
        prevMin.next = null;
        minEletopAddr = prevMin;
      } else {
        minEletopAddr = null;
        minElebaseAddr = minEletopAddr;
      }
    }
  }

  public int top() {
    return topAddr.value;
  }

  protected void print() {
    Node bAdr = baseAddr.next;
    while (bAdr != null) {
      System.out.print(bAdr.value + ", ");
      bAdr = bAdr.next;
    }
    System.out.println();
  }

  public int getMin() {
    Node minEle = minEletopAddr;
    int ele = minEle.value;
    return ele;
  }
}

public class _156_Min_Stack {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.print();
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top()); // return 0
    // minStack.print();
    System.out.println(minStack.getMin()); // return -2
  }
}
