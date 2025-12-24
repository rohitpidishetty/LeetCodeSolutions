import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedIterator implements Iterator<Integer> {

  private int pointer;
  private Queue<Integer> q;

  private void arrangeInts(List<NestedInteger> nestedList) {
    if (nestedList.isEmpty()) return;
    for (NestedInteger ni_obj : nestedList) {
      if (ni_obj.isInteger()) q.offer(ni_obj.getInteger());
      else arrangeInts(ni_obj.getList());
    }
  }

  public NestedIterator(List<NestedInteger> nestedList) {
    q = new ArrayDeque<>();
    arrangeInts(nestedList);
  }

  @Override
  public Integer next() {
    return q.poll();
  }

  @Override
  public boolean hasNext() {
    return !q.isEmpty();
  }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
