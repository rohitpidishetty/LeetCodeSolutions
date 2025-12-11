class MyHashMap {

  private class CollidedBinaryTree {

    protected int k, v;

    CollidedBinaryTree(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }

  private CollidedBinaryTree k_v_buf[];

  public MyHashMap() {
    this.k_v_buf = new CollidedBinaryTree[1000001];
  }

  public void put(int key, int value) {
    this.k_v_buf[key] = new CollidedBinaryTree(key, value);
  }

  public int get(int key) {
    if (this.k_v_buf[key] == null) return -1;
    return this.k_v_buf[key].v;
  }

  public void remove(int key) {
    this.k_v_buf[key] = null;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class _706_Design_HashMap {

  public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(1, 9);
    System.out.println(obj.get(1));
    obj.remove(1);
  }
}
