class Node {

  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {

  public Node copyRandomList(Node head) {
    Node temp = head;
    while (temp != null) {
      Node save = temp.next;
      Node node = new Node(temp.val);
      temp.next = node;
      node.next = save;
      temp = save;
    }

    temp = head;
    while (temp != null) {
      Node next = temp.next.next;
      temp.next.random = temp.random == null ? null : temp.random.next;
      temp = next;
    }

    Node dummy = new Node(-1);
    temp = head;
    Node ret = dummy;
    while (temp != null) {
      Node next = temp.next.next;
      dummy.next = temp.next;
      dummy = dummy.next;
      temp.next = next;
      temp = next;
    }

    return ret.next;
  }
}

public class _138_Copy_List_with_Random_Pointer {

  public static void main(String[] args) {
    Node n1 = new Node(7);
    Node n2 = new Node(13);
    Node n3 = new Node(11);
    Node n4 = new Node(10);
    Node n5 = new Node(1);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = null;

    n1.random = null;
    n2.random = n1;
    n3.random = n5;
    n4.random = n3;
    n5.random = n1;

    Node head = n1;

    Node node = new Solution().copyRandomList(head);
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}
