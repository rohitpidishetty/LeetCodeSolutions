import java.util.Stack;

class StockSpanner {

  private Stack<int[]> s;

  public StockSpanner() {
    s = new Stack<>();
  }

  public int next(int price) {
    int res = 1;
    while (!s.isEmpty() && price >= s.peek()[0]) res += s.pop()[1];
    s.add(new int[] { price, res });
    return res;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
public class _901_Online_Stock_Span {

  public static void main(String[] args) {
    StockSpanner ss = new StockSpanner();
    System.out.println(ss.next(100));
  }
}
