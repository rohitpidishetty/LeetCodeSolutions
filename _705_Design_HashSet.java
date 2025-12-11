import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyHashSet {

  private int hash(int key) {
    return (key << 4) ^ 2;
  }

  private Map<Integer, Integer> map;

  public MyHashSet() {
    List<Integer> buff = new ArrayList<>();
    this.map = new HashMap<>();
  }

  public void add(int key) {
    int h = hash(key);
    if (this.map.containsKey(h)) return;
    this.map.put(h, key);
  }

  public void remove(int key) {
    int h = hash(key);
    if (!this.map.containsKey(h)) return;
    this.map.remove(h);
  }

  public boolean contains(int key) {
    return this.map.containsKey(hash(key));
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
