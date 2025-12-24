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
    Node prev = head;
    while (prev != null) {
      Node newNode = new Node(prev.val);
      Node save = prev.next;
      prev.next = newNode;
      newNode.next = save;
      prev = save;
    }

    Node curr = head;
    while (curr != null) {
      curr.next.random = curr.random == null ? null : curr.random.next;
      curr = curr.next.next;
    }

    Node copy = null;
    Node duplicate = null;

    while (head != null) {
      if (copy == null) {
        copy = head.next;
        duplicate = copy;
      } else {
        copy.next = head.next;
        copy = copy.next;
      }
      head.next = head.next.next;
      head = head.next;
    }
    return duplicate;
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

    n2.random = n1;
    n3.random = n5;
    n4.random = n3;
    n5.random = n1;

    Node newHead = new Solution().copyRandomList(n1);
    System.out.println("_-----------------------------_");
    while (newHead != null) {
      System.out.println(newHead.val);
      System.out.println("Np: " + (newHead.next == null ? "null" : newHead.next.val));
      System.out.println("Rp: " + (newHead.random == null ? "null" : newHead.random.val));
      newHead = newHead.next;
    }

  }
}
