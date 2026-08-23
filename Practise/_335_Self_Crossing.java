class Solution {

  public boolean isSelfCrossing(int[] distance) {
    int n = distance.length;
    if (n < 4) return false;
    for (int i = 3; i < n; i++) {
      if (
        (distance[i] >= distance[i - 2] &&
          distance[i - 1] <= distance[i - 3]) ||
        (i >= 4 &&
          distance[i - 1] == distance[i - 3] &&
          distance[i] + distance[i - 4] >= distance[i - 2]) ||
        (i >= 5 &&
          distance[i - 2] >= distance[i - 4] &&
          distance[i] + distance[i - 4] >= distance[i - 2] &&
          distance[i - 1] <= distance[i - 3] &&
          distance[i - 1] + distance[i - 5] >= distance[i - 3])
      ) return true;
    }
    return false;
  }
}

public class _335_Self_Crossing {

  public static void main(String[] args) {
    System.out.println(new Solution().isSelfCrossing(new int[] { 2, 1, 1, 2 }));
  }
}
