class MyCircularQueue {

  class CirQueNode {

    protected int value;
    protected CirQueNode next;

    public CirQueNode(int value, CirQueNode next) {
      this.value = value;
      this.next = next;
    }
  }

  private int CURRENT_CAPACITY = 0;
  private CirQueNode front, rear;

  public MyCircularQueue(int k) {
    this.CURRENT_CAPACITY = k;
    this.front = null;
    this.rear = null;
  }

  private CirQueNode initiateNewInstance(int value) {
    return new CirQueNode(value, null);
  }

  public boolean enQueue(int value) {
    if (this.CURRENT_CAPACITY > 0) {
      CirQueNode instance = initiateNewInstance(value);
      if (this.front == null && this.rear == null) {
        this.front = instance;
        this.rear = instance;
      } else {
        this.rear.next = instance;
        this.rear = instance;
      }
      this.CURRENT_CAPACITY--;
      return true;
    }
    return false;
  }

  public boolean deQueue() {
    if (this.rear == null && this.front == null) return false;
    if (this.front == this.rear) {
      this.front = null;
      this.rear = null;
    } else this.front = this.front.next;

    this.CURRENT_CAPACITY++;
    return true;
  }

  public int Front() {
    return this.front == null ? -1 : this.front.value;
  }

  public int Rear() {
    return this.rear == null ? -1 : this.rear.value;
  }

  public boolean isEmpty() {
    return this.rear == null && this.front == null;
  }

  public boolean isFull() {
    return this.CURRENT_CAPACITY == 0;
  }
}

public class _622_Design_Circular_Queue {

  /**
   * [
   * "MyCircularQueue", (6)
   * "enQueue", (6)
   * "Rear",
   * "Rear",
   * "deQueue",
   * "enQueue", (5)
   * "Rear",
   * "deQueue",
   * "Front",
   * "deQueue",
   * "deQueue",
   * "deQueue"
   * ]
   */
  public static void main(String[] args) {
    MyCircularQueue obj = new MyCircularQueue(6);
    obj.enQueue(6);
    System.out.println(obj.Rear());
    System.out.println(obj.Rear());
    obj.deQueue();
    obj.enQueue(5);
    System.out.println(obj.Rear());
    obj.deQueue();
    System.out.println(obj.Front());
    obj.deQueue();
    obj.deQueue();
    obj.deQueue();
  }
}
