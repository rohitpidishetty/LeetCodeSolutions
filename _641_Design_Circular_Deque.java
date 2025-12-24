class MyCircularDeque {

  private class DeNode {

    protected int value;
    protected DeNode left, right;

    public DeNode(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  private int THRESHOLD;
  private DeNode front, rear;

  public MyCircularDeque(int k) {
    this.front = null;
    this.rear = null;
    this.THRESHOLD = k;
  }

  public boolean insertFront(int value) {
    if (this.THRESHOLD <= 0) return false;
    DeNode deNode = new DeNode(value);
    if (this.front == null && this.rear == null) {
      this.front = deNode;
      this.rear = deNode;
    } else {
      this.front.left = deNode;
      deNode.right = this.front;
      this.front = deNode;
    }
    this.THRESHOLD--;
    return true;
  }

  public boolean insertLast(int value) {
    if (this.THRESHOLD <= 0) return false;
    DeNode deNode = new DeNode(value);
    if (this.front == null && this.rear == null) {
      this.front = deNode;
      this.rear = deNode;
    } else {
      this.rear.right = deNode;
      deNode.left = this.rear;
      this.rear = deNode;
    }
    this.THRESHOLD--;
    return true;
  }

  public boolean deleteFront() {
    if (this.front == null) return false;
    if (this.front == this.rear) {
      this.front = null;
      this.rear = null;
    } else this.front = this.front.right;
    this.THRESHOLD++;
    return true;
  }

  public boolean deleteLast() {
    if (this.rear == null) return false;
    if (this.front == this.rear) {
      this.front = null;
      this.rear = null;
    } else this.rear = this.rear.left;
    this.THRESHOLD++;
    return true;
  }

  public int getFront() {
    if (this.front == null) return -1;
    return this.front.value;
  }

  public int getRear() {
    if (this.rear == null) return -1;
    return this.rear.value;
  }

  public boolean isEmpty() {
    return this.front == null && this.rear == null;
  }

  public boolean isFull() {
    return this.THRESHOLD == 0;
  }
}

public class _641_Design_Circular_Deque {

  public static void main(String[] args) {
    /**
     * [
     * "MyCircularDeque", (8)
     * "insertFront",     (5)
     * "getFront",        ( )
     * "isEmpty",         ( )
     * "deleteFront",     ( )
     * "insertLast",      (3)
     * "getRear",         ( )
     * "insertLast",      (7)
     * "insertFront",     (7)
     * "deleteLast",      ( )
     * "insertLast",      (4)
     * "isEmpty"          ( )
     * ]
     */
    MyCircularDeque obj = new MyCircularDeque(8);
    System.out.println(obj.insertFront(5));
    System.out.println(obj.getFront());
    System.out.println(obj.isEmpty());
    System.out.println(obj.deleteFront());
    System.out.println(obj.insertLast(3));
    System.out.println(obj.getRear());
    System.out.println(obj.insertLast(7));
    System.out.println(obj.insertFront(7));
    System.out.println(obj.deleteLast());
    System.out.println(obj.insertLast(4));
    System.out.println(obj.isEmpty());
  }
}
