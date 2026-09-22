import java.util.PriorityQueue;

class Solution {

  public long totalCost(int[] costs, int k, int candidates) {
    PriorityQueue<Integer> left = new PriorityQueue<>();
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int i = 0;
    int n = costs.length;
    for (; i < candidates && i < n; i++) left.add(costs[i]);
    int j = n - 1;
    int count = 0;

    for (; count < candidates && j >= i; j--, count++) right.add(costs[j]);

    long cost = 0;
    for (int s = 0; s < k; s++) {
      if (!left.isEmpty() && !right.isEmpty()) {
        int candidate1 = left.peek();
        int candidate2 = right.peek();
        if (candidate1 <= candidate2) {
          cost += candidate1;
          left.poll();
          if (i <= j) left.add(costs[i++]);
        } else {
          cost += candidate2;
          right.poll();
          if (j >= i) right.add(costs[j--]);
        }
      } else if (left.isEmpty()) {
        int candidate2 = right.peek();
        cost += candidate2;
        right.poll();
        if (j >= i) right.add(costs[j--]);
      } else {
        int candidate1 = left.peek();
        cost += candidate1;
        left.poll();
        if (i <= j) left.add(costs[i++]);
      }
    }

    return cost;
  }
}

public class _462_Total_Cost_to_Hire_K_Workers {

  public static void main(String[] args) {
    System.out.println(
      new Solution().totalCost(
        new int[] { 17, 12, 10, 2, 7, 2, 11, 20, 8 },
        3,
        4
      )
    );
  }
}
