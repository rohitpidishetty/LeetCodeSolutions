import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node {

  protected int key;
  protected int freq;
  protected int value;
  protected Node left;
  protected Node right;

  public Node(int key, int value, int freq) {
    this.key = key;
    this.value = value;
    this.freq = freq;
  }
}

class LFUCache {

  protected Map<Integer, Node> storageBuffer;
  protected int threshold;
  protected Map<Integer, Node> freqMap;
  protected PriorityQueue<Integer> freqHeap;

  public LFUCache(int capacity) {
    storageBuffer = new HashMap<>();
    freqMap = new HashMap<>();
    threshold = capacity;
    freqHeap = new PriorityQueue<>();
  }

  public int get(int key) {
    if (!storageBuffer.containsKey(key)) return -1;
    Node chain = storageBuffer.get(key);
    int oldFreq = chain.freq;
    chain.freq++;
    Node oldHead = freqMap.get(oldFreq);
    if (oldHead == chain) {
      if (chain.right != null) freqMap.put(oldFreq, chain.right);
      else freqMap.remove(oldFreq);
    }
    if (chain.left != null) chain.left.right = chain.right;
    if (chain.right != null) chain.right.left = chain.left;
    chain.left = chain.right = null;
    Node nextChain = freqMap.get(chain.freq);
    if (nextChain != null) {
      nextChain.left = chain;
      chain.right = nextChain;
    }
    freqMap.put(chain.freq, chain);
    freqHeap.offer(chain.freq);
    if (freqMap.get(oldFreq) == null) freqHeap.remove(oldFreq);
    return chain.value;
  }

  public void put(int key, int value) {
    if (threshold == 0) return;

    if (!storageBuffer.containsKey(key) && storageBuffer.size() >= threshold) {
      while (!freqHeap.isEmpty()) {
        int minFreq = freqHeap.peek();
        Node head = freqMap.get(minFreq);
        if (head == null) {
          freqHeap.poll();
          continue;
        }
        while (head.right != null) head = head.right;
        if (head.left != null) head.left.right = null;
        else freqMap.remove(minFreq);
        storageBuffer.remove(head.key);
        break;
      }
    }

    if (!storageBuffer.containsKey(key)) {
      Node node = new Node(key, value, 1);
      storageBuffer.put(key, node);
      Node chain = freqMap.get(1);
      if (chain != null) {
        node.right = chain;
        chain.left = node;
      }
      freqMap.put(1, node);
      freqHeap.offer(1);
      return;
    }

    Node node = storageBuffer.get(key);
    node.value = value;
    int oldFreq = node.freq;
    Node head = freqMap.get(oldFreq);
    if (node.left != null) node.left.right = node.right;
    if (node.right != null) node.right.left = node.left;
    if (head == node) {
      if (node.right != null) freqMap.put(oldFreq, node.right);
      else freqMap.remove(oldFreq);
    }
    node.left = node.right = null;
    node.freq++;
    Node nextHead = freqMap.get(node.freq);
    if (nextHead != null) {
      node.right = nextHead;
      nextHead.left = node;
    }
    freqMap.put(node.freq, node);
    freqHeap.offer(node.freq);
  }
}

public class _460_LFU_Cache {

  public static void main(String[] args) {
    LFUCache cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(1, 2);
    cache.put(2, 2);
    cache.put(2, 3);
  }
}
