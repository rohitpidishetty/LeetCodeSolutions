import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class LRUCache {
  private int threshold;
  protected Map<Integer, Integer> cache;
  private Queue<Integer> LRU_q;

  public LRUCache(int capacity) {
    this.threshold = capacity;
    this.cache = new HashMap<>();
    this.LRU_q = new ArrayDeque<>();
  }

  public int get(int key) {
    if (!this.cache.containsKey(key))
      return -1;
    this.LRU_q.remove(key);
    this.LRU_q.offer(key);
    return this.cache.get(key);
  }

  public void put(int key, int value) {
    if (this.cache.containsKey(key)) {
      this.LRU_q.remove(key);
      this.cache.put(key, value);
      this.LRU_q.offer(key);
    } else {
      if (this.cache.size() < this.threshold) {
        this.cache.put(key, value);
        this.LRU_q.offer(key);
      } else {
        if (!this.LRU_q.isEmpty()) {
          int k = this.LRU_q.peek();
          this.cache.remove(k);
          this.LRU_q.poll();
          this.cache.put(key, value);
        } else {
          this.cache.put(key, value);
          this.LRU_q.offer(key);
        }
      }
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class _146_LRU_Cache {
  public static void main(String[] args) {
    // LRUCache lRUCache = new LRUCache(2);
    // lRUCache.put(1, 1); // cache is {1=1}
    // System.out.println(lRUCache.cache);
    // lRUCache.put(2, 2); // cache is {1=1, 2=2}
    // System.out.println(lRUCache.cache);
    // int ret = lRUCache.get(1); // return 1
    // System.out.println(ret);
    // lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    // System.out.println(lRUCache.cache);
    // ret = lRUCache.get(2); // returns -1 (not found)
    // System.out.println(ret);
    // lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    // System.out.println(lRUCache.cache);
    // ret = lRUCache.get(1); // return -1 (not found)
    // System.out.println(ret);
    // ret = lRUCache.get(3); // return 3
    // System.out.println(ret);
    // ret = lRUCache.get(4); // return 4
    // System.out.println(ret);

    // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    LRUCache lru = new LRUCache(2);
    int ret = 1;
    ret = lru.get(2);
    System.out.println(ret);
    lru.put(2, 6);
    System.out.println(lru.cache);
    ret = lru.get(1);
    System.out.println(ret);
    lru.put(1, 5);
    System.out.println(lru.cache);
    System.out.println(" ---- ");
    lru.put(1, 2);
    System.out.println(lru.cache);
    ret = lru.get(1);
    System.out.println(ret);
    ret = lru.get(2);
    System.out.println(ret);

  }
}
