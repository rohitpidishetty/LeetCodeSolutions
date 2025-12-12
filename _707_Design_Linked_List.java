class MyLinkedList {

  private class DeNode {

    protected int value;
    protected DeNode left = null, right = null;

    DeNode(int value) {
      this.value = value;
    }
  }

  private DeNode head_ptr = null, tail_ptr = null;

  public MyLinkedList() {}

  public void addAtHead(int val) {
    DeNode node = new DeNode(val);
    if (this.head_ptr == null && this.tail_ptr == null) this.tail_ptr = node;
    else {
      node.right = this.head_ptr;
      this.head_ptr.left = node;
    }
    this.head_ptr = node;
  }

  public void addAtTail(int val) {
    DeNode node = new DeNode(val);
    if (this.head_ptr == null && this.tail_ptr == null) this.head_ptr = node;
    else {
      node.left = this.tail_ptr;
      this.tail_ptr.right = node;
    }
    this.tail_ptr = node;
  }

  public void addAtIndex(int index, int val) {
    DeNode node = new DeNode(val);
    if (index == 0) {
      if (this.head_ptr == null && this.tail_ptr == null) addAtHead(val);
      this.head_ptr.left = node;
      node.right = this.head_ptr;
      this.head_ptr = node;
      return;
    }
    int idx = 0;
    DeNode voyager_ptr = this.head_ptr;
    while (idx < index && voyager_ptr != null) {
      voyager_ptr = voyager_ptr.right;
      idx++;
    }
    if (voyager_ptr == null) {
      if (this.tail_ptr == null) return;
      this.tail_ptr.right = node;
      node.left = this.tail_ptr;
      this.tail_ptr = node;
      return;
    }
    DeNode prev = voyager_ptr.left;
    DeNode next = prev.right;
    prev.right = node;
    node.left = prev;
    node.right = next;
    next.left = node;
  }

  public int get(int index) {
    if (this.head_ptr == null && this.tail_ptr == null) return -1;

    int idx = 0;
    DeNode voyager_ptr = this.head_ptr;
    while (idx < index && voyager_ptr != null) {
      voyager_ptr = voyager_ptr.right;
      idx++;
    }
    return voyager_ptr != null ? voyager_ptr.value : -1;
  }

  public void deleteAtIndex(int index) {
    if (index == 0) {
      if (this.head_ptr == null && this.tail_ptr == null) return;
      this.head_ptr = this.head_ptr.right;
      if (this.head_ptr == null) {
        return;
      }
      this.head_ptr.left = null;
      return;
    }
    int idx = 0;
    DeNode voyager_ptr = this.head_ptr;
    while (idx < index) {
      voyager_ptr = voyager_ptr.right;
      idx++;
    }

    if (voyager_ptr == null) {
      return;
    }

    DeNode prev = voyager_ptr.left;
    DeNode next = voyager_ptr.right;
    if (voyager_ptr.right == null) {
      prev.right = null;
      this.tail_ptr = prev;
      return;
    }

    if (voyager_ptr.left == null) {
      next.left = null;
      this.head_ptr = next;
      return;
    }

    prev.right = next;
    next.left = prev;
  }
}

public class _707_Design_Linked_List {

  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();

    obj.addAtIndex(1, 0);
    // obj.get(1);
  }
}
