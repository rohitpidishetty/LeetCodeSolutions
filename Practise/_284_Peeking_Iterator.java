// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {

  static class iterableChainNode {

    Integer data;
    iterableChainNode next;

    public iterableChainNode(Integer data, iterableChainNode next) {
      this.data = data;
      this.next = next;
    }
  }

  private iterableChainNode head = null;
  private iterableChainNode headBinder = null;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here
    while (iterator.hasNext()) {
      Integer val = iterator.next();
      iterableChainNode newLoc = new iterableChainNode(val, null);
      if (head == null) {
        head = newLoc;
        headBinder = head;
      } else {
        headBinder.next = newLoc;
        headBinder = newLoc;
      }
    }
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return head.data;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (head == null) throw new NoSuchElementException();
    Integer next = head.data;
    head = head.next;
    return next;
  }

  @Override
  public boolean hasNext() {
    return head != null;
  }
}

public class _284_Peeking_Iterator {

  public static void main(String[] args) {
    Iterator<Integer> itr = new ArrayList<Integer>(
      List.of(1, 2, 3, 4, 5)
    ).iterator();
    PeekingIterator pItr = new PeekingIterator(itr);
  }
}
