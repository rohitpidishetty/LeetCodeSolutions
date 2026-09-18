import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

  static class CacheStore {

    protected CacheStore leftPtr, rightPtr;
    protected int key, value;

    public CacheStore(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return String.format("{%d->%d}", key, value);
    }
  }

  private int SIZE;
  public CacheStore front, rear;
  private Map<Integer, CacheStore> address;

  public LRUCache(int capacity) {
    SIZE = capacity;
    address = new HashMap<>();
  }

  private void updateFront(CacheStore pair) {
    pair.leftPtr = null;
    pair.rightPtr = front;
    if (front != null) front.leftPtr = pair;
    front = pair;
    if (rear == null) rear = pair;
  }

  public int get(int key) {
    if (address.containsKey(key)) {
      CacheStore pair = address.get(key);

      if (pair.leftPtr != null && pair.rightPtr != null) {
        pair.leftPtr.rightPtr = pair.rightPtr;
        pair.rightPtr.leftPtr = pair.leftPtr;
        updateFront(pair);
        return pair.value;
      } else if (pair.leftPtr == null && pair.rightPtr != null) {
        return pair.value;
      } else if (pair.leftPtr != null && pair.rightPtr == null) {
        rear = pair.leftPtr;
        rear.rightPtr = null;
        updateFront(pair);
        return pair.value;
      } else {
        return pair.value;
      }
    }

    return -1;
  }

  public void put(int key, int value) {
    if (address.containsKey(key)) {
      CacheStore pair = address.get(key);
      pair.value = value;

      if (pair.leftPtr != null && pair.rightPtr != null) {
        // Re-attaching left and right pointers
        pair.leftPtr.rightPtr = pair.rightPtr;
        pair.rightPtr.leftPtr = pair.leftPtr;
        updateFront(pair);
        return;
      } else if (pair.leftPtr == null && pair.rightPtr != null) {
        return;
      } else if (pair.leftPtr != null && pair.rightPtr == null) {
        rear = pair.leftPtr;
        rear.rightPtr = null;
        updateFront(pair);

        return;
      }
      return;
    }

    if (SIZE == 0) {
      address.remove(rear.key);

      if (front == rear) {
        front = null;
        rear = null;
      } else {
        rear = rear.leftPtr;
        rear.rightPtr = null;
      }

      SIZE++;
    }
    // first run
    CacheStore pair = new CacheStore(key, value);
    if (front == null && rear == null) {
      front = pair;
      rear = pair;
    } else {
      front.leftPtr = pair;
      pair.rightPtr = front;
      front = pair;
    }
    address.put(key, pair);

    SIZE--;
  }
}

public class _146_LRU_Cache {

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    // LRUCache.CacheStore cs = lRUCache.front;
    // while (cs != null) {
    //   System.out.println(cs);
    //   cs = cs.rightPtr;
    // }
    // System.out.println();
    System.out.println(lRUCache.get(1)); // return 1
    // cs = lRUCache.front;
    // while (cs != null) {
    //   System.out.println(cs);
    //   cs = cs.rightPtr;
    // }
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    // cs = lRUCache.front;
    // while (cs != null) {
    //   System.out.println(cs);
    //   cs = cs.rightPtr;
    // }
    System.out.println(lRUCache.get(2)); // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1)); // return -1 (not found)
    System.out.println(lRUCache.get(3)); // return 3
    System.out.println(lRUCache.get(4)); // return 4
  }
}
