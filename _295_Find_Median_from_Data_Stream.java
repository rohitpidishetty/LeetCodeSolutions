import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Version 2 (Using PriorityQueues)
class MedianFinder {

  private Queue<Integer> maxHeap;
  private Queue<Integer> minHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.offer(num);
    else minHeap.offer(num);
    // Balancing
    if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
    else if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
  }

  public double findMedian() {
    int a = maxHeap.size();
    int b = minHeap.size();
    if (a == b) return (double) (maxHeap.peek() + minHeap.peek()) / 2d;
    else if (a > b) return maxHeap.peek();
    return minHeap.peek();
  }
}

public class _295_Find_Median_from_Data_Stream {

  public static void main(String[] args) {
    MedianFinder mfdr = new MedianFinder();
    mfdr.addNum(2);
    mfdr.addNum(10);
    mfdr.addNum(6);
    mfdr.addNum(3);
    mfdr.addNum(1);

    System.out.println(mfdr.findMedian());
  }
}

class MedianFinder_v0 {

  private LinkedList head;
  private int magnitude;

  static class LinkedList {

    protected int data;
    protected LinkedList address;

    public LinkedList(int data, LinkedList address) {
      this.data = data;
      this.address = address;
    }
  }

  public MedianFinder_v0() {
    magnitude = 0;
    head = new LinkedList(Integer.MIN_VALUE, null);
  }

  public void addNum(int num) {
    magnitude++;
    LinkedList newNode = new LinkedList(num, null);
    LinkedList placer = head;
    if (placer.address == null) {
      placer.address = newNode;
    } else {
      while (placer.address != null && placer.address.data <= num) placer =
        placer.address;
      if (placer.address == null) placer.address = newNode;
      else {
        LinkedList save = placer.address;
        placer.address = newNode;
        newNode.address = save;
      }
    }
  }

  public double findMedian() {
    if (magnitude < 2) return 0;
    LinkedList slowPtr = head.address;
    LinkedList fastPtr = head.address;
    LinkedList previousPtr = null;
    do {
      previousPtr = slowPtr;
      slowPtr = slowPtr.address;
      fastPtr = fastPtr.address.address;
    } while (fastPtr != null && fastPtr.address != null);

    return (magnitude % 2 != 0)
      ? slowPtr.data
      : (double) (previousPtr.data + slowPtr.data) / 2d;
  }
}
