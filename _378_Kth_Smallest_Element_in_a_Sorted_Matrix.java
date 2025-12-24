import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

  public int kthSmallest(int[][] matrix, int k) {
    int index = 0, i = 0, j = 0;
    int start[] = { i, j, matrix[i][j] };
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    pQ.offer(start);
    int n = matrix.length;
    while (!pQ.isEmpty()) {
      int currentNode[] = pQ.poll();
      int curr_i = currentNode[0];
      int curr_j = currentNode[1];
      int curr_val = currentNode[2];
      index++;
      if (index == k) return curr_val;
      if (curr_i + 1 < n && matrix[curr_i + 1][curr_j] != Integer.MAX_VALUE) {
        pQ.offer(new int[] { curr_i + 1, curr_j, matrix[curr_i + 1][curr_j] });
        matrix[curr_i + 1][curr_j] = Integer.MAX_VALUE;
      }
      if (curr_j + 1 < n && matrix[curr_i][curr_j + 1] != Integer.MAX_VALUE) {
        pQ.offer(new int[] { curr_i, curr_j + 1, matrix[curr_i][curr_j + 1] });
        matrix[curr_i][curr_j + 1] = Integer.MAX_VALUE;
      }
    }
    return -1;
  }
}

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .kthSmallest(
          new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } },
          8
        )
    );
  }
}
