import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  private class Worker {

    protected int quality, wage;
    protected double ratio;

    public Worker(int quality, int wage, double ratio) {
      this.quality = quality;
      this.ratio = ratio;
      this.wage = wage;
    }

    @Override
    public String toString() {
      return (
        "{q=" + this.quality + ", w=" + this.wage + ", r=" + this.ratio + "}"
      );
    }
  }

  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int n = quality.length;
    Worker[] workers = new Worker[n];
    for (int i = 0; i < n; i++) {
      workers[i] = new Worker(
        quality[i],
        wage[i],
        (wage[i] / (double) quality[i])
      );
    }
    double minCost = Double.MAX_VALUE;
    Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
    PriorityQueue<Worker> pQ = new PriorityQueue<>((a, b) ->
      Double.compare(b.quality, a.quality)
    );
    int cost = 0;
    for (int manager = 0; manager < n; manager++) {
      pQ.add(workers[manager]);
      cost += workers[manager].quality;

      if (pQ.size() > k) cost -= pQ.poll().quality;

      if (pQ.size() == k) minCost = Math.min(
        minCost,
        cost * workers[manager].ratio
      );
    }
    return minCost;
  }
}

public class _857_Minimum_Cost_to_Hire_K_Workers {

  public static void main(String[] args) {
    System.out.println(
      new Solution().mincostToHireWorkers(
        new int[] { 3, 1, 10, 10, 1 },
        new int[] { 4, 8, 2, 2, 7 },
        3
      )
    );
  }
}
