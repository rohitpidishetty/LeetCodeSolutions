import java.util.*;

class AllOne {

  class DLL {

    protected DLL prev;
    protected DLL next;
    protected int freq;
    protected Set<String> keys;

    protected DLL(int freq) {
      this.freq = freq;
      this.keys = new HashSet<>();
    }
  }

  private Map<String, Integer> keyCount;
  private Map<Integer, DLL> freqMap;
  private DLL head;
  private DLL tail;

  public AllOne() {
    keyCount = new HashMap<>();
    freqMap = new HashMap<>();
    head = new DLL(0);
    tail = new DLL(0);
    head.next = tail;
    tail.prev = head;
  }

  public void inc(String key) {
    int freq = keyCount.getOrDefault(key, 0);
    keyCount.put(key, freq + 1);

    DLL currNode = freqMap.get(freq);
    DLL nextNode = freqMap.get(freq + 1);

    if (nextNode == null) {
      nextNode = new DLL(freq + 1);
      freqMap.put(freq + 1, nextNode);
      insertAfter(currNode == null ? head : currNode, nextNode);
    }

    nextNode.keys.add(key);

    if (currNode != null) {
      currNode.keys.remove(key);
      if (currNode.keys.isEmpty()) removeNode(currNode);
    }
  }

  public void dec(String key) {
    if (!keyCount.containsKey(key)) return;

    int freq = keyCount.get(key);
    DLL currNode = freqMap.get(freq);

    if (freq == 1) {
      keyCount.remove(key);
    } else {
      keyCount.put(key, freq - 1);
      DLL prevNode = freqMap.get(freq - 1);
      if (prevNode == null) {
        prevNode = new DLL(freq - 1);
        freqMap.put(freq - 1, prevNode);
        insertAfter(currNode.prev, prevNode);
      }
      prevNode.keys.add(key);
    }

    currNode.keys.remove(key);
    if (currNode.keys.isEmpty()) removeNode(currNode);
  }

  public String getMaxKey() {
    return tail.prev == head ? "" : tail.prev.keys.iterator().next();
  }

  public String getMinKey() {
    return head.next == tail ? "" : head.next.keys.iterator().next();
  }

  private void insertAfter(DLL node, DLL newNode) {
    newNode.prev = node;
    newNode.next = node.next;
    node.next.prev = newNode;
    node.next = newNode;
  }

  private void removeNode(DLL node) {
    freqMap.remove(node.freq);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
