import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> buffer = new ArrayList<>();
    int i = 0, j = arr.length - 1, n = j;

    while (i < j) {
      int m = (i + j) / 2;
      if (arr[m] < x) i = m + 1;
      else j = m;
    }

    j = i;
    i = i - 1;
    int winCount = 0;
    while (winCount < k) {
      if (i < 0) {
        buffer.add(arr[j++]);
        winCount++;
      } else if (j > n) {
        buffer.add(arr[i--]);
        winCount++;
      } else {
        if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
          buffer.add(arr[i--]);
          winCount++;
        } else {
          buffer.add(arr[j++]);
          winCount++;
        }
      }
    }

    Collections.sort(buffer);
    return buffer;
  }
}

public class _658_Find_K_Closest_Elements {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findClosestElements(new int[] { 0, 0, 1, 2, 3, 3, 4, 7, 7, 8 }, 3, 5)
    );
  }
}
