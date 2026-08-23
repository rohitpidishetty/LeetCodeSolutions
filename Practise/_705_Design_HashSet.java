import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyHashSet {

  private boolean[] map;

  public MyHashSet() {
    this.map = new boolean[1000001];
  }

  public void add(int key) {
    this.map[key] = true;
  }

  public void remove(int key) {
    this.map[key] = false;
  }

  public boolean contains(int key) {
    return this.map[key];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
public class _705_Design_HashSet {

  public static void main(String[] args) {
    MyHashSet obj = new MyHashSet();
  }
}
