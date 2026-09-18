class Solution {

  public int findMinMoves(int[] machines) {
    int n = machines.length;
    int sum = 0;
    for (int machine : machines) sum += machine;
    if (sum % n != 0) return -1;
    int avg = sum / n;
    int totalDiff = 0;
    int moves = 0;
    for (int clothes : machines) {
      int currDiff = clothes - avg;
      totalDiff += currDiff;
      moves = Math.max(moves, Math.max(Math.abs(totalDiff), currDiff));
    }
    return moves;
  }
}

public class _517_Super_Washing_Machines {

  public static void main(String[] args) {
    System.out.println(new Solution().findMinMoves(new int[] { 1, 0, 5 }));
  }
}
