class Node {
  int data = 0;
  Node next = null;

  Node(int data) {
    this.data = data;
  }

  Node(int data, Node previousPointer) {
    this.data = data;
    previousPointer.next = this;
  }
}

public class LinkedList {
  public static void main(String[] args) {
    Node n1 = new Node(10);
    Node n2 = new Node(20, n1);
    Node n3 = new Node(30, n2);

    // System.out.println(n1);
    // System.out.println(n1.data);

    while (n1 != null) {
      System.out.println(n1.data);
      n1 = n1.next;
    }
  }
}