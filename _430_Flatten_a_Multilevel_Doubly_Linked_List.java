class Node {

  public int val;
  public Node prev;
  public Node next;
  public Node child;

  public Node(int val) {
    this.val = val;
    this.prev = null;
    this.next = null;
    this.child = null;
  }
}

class Solution {

  private Node dfs(Node head) {
    if (head == null) return null;
    if (head.child == null && head.next == null) return head;
    Node child = (head.child == null) ? dfs(head.next) : dfs(head.child);

    if (head.next != child) {
      Node save = head.next;
      head.next = child;
      child.prev = head;
      Node temp = head;
      while (temp.next != null) temp = temp.next;
      temp.next = save;
      while (temp.next != null) {
        temp.next.prev = temp;
        temp = temp.next;
      }
    } else {
      head.next = child;
      child.prev = head;
    }
    head.child = null;
    return head;
  }

  public Node flatten(Node head) {
    return dfs(head);
  }
}

public class _430_Flatten_a_Multilevel_Doubly_Linked_List {

  public static Node createList() {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    n1.next = n2;
    n2.prev = n1;
    n2.next = n3;
    n3.prev = n2;
    n3.next = n4;
    n4.prev = n3;
    n4.next = n5;
    n5.prev = n4;
    n5.next = n6;
    n6.prev = n5;
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);
    Node n10 = new Node(10);
    n7.next = n8;
    n8.prev = n7;
    n8.next = n9;
    n9.prev = n8;
    n9.next = n10;
    n10.prev = n9;
    n3.child = n7;
    Node n11 = new Node(11);
    Node n12 = new Node(12);
    n11.next = n12;
    n12.prev = n11;
    n8.child = n11;
    return n1;
  }

  public static void main(String[] args) {
    Node ret = new Solution().flatten(createList());
    while (ret != null) {
      System.out.println(
        ret.val +
        " " +
        (ret.child) +
        " prev: " +
        (ret.prev == null ? "null" : ret.prev.val)
      );
      ret = ret.next;
    }
  }
}
