// import java.util.*;

// class Solution {

//   // 92 / 94 (TLE)
//   public int[] smallestRange(List<List<Integer>> nums) {
//     int n = nums.size();
//     int[] indices = new int[2];
//     int pointers[] = new int[n];
//     int limits[] = new int[n];
//     int min_index = -1;
//     int min_arr_len = Integer.MAX_VALUE;
//     for (int i = 0; i < n; i++) {
//       limits[i] = nums.get(i).size();
//       if (limits[i] < min_arr_len) {
//         min_index = i;
//         min_arr_len = limits[i];
//       }
//     }
//     int MIN_VAL = Integer.MAX_VALUE, MIN_VAL_IDX_PTR = -1, MAX_VAL =
//       Integer.MIN_VALUE;
//     int min_distance = Integer.MAX_VALUE;
//     while (true) {
//       int idx = 0;
//       MIN_VAL = Integer.MAX_VALUE;
//       MAX_VAL = Integer.MIN_VALUE;
//       for (int ptr : pointers) {
//         if (pointers[idx] >= limits[idx]) return indices;
//         int val = nums.get(idx).get(ptr);
//         if (val < MIN_VAL) {
//           MIN_VAL = val;
//           MIN_VAL_IDX_PTR = idx;
//         }
//         if (val > MAX_VAL) MAX_VAL = val;
//         idx++;
//       }
//       if (MAX_VAL - MIN_VAL < min_distance) {
//         indices = new int[] { MIN_VAL, MAX_VAL };
//         min_distance = MAX_VAL - MIN_VAL;
//       }
//       pointers[MIN_VAL_IDX_PTR]++;
//     }
//   }
// }

// public class _632_Smallest_Range_Covering_Elements_from_K_Lists {

//   public static void main(String[] args) {
//     System.out.println(
//       Arrays.toString(
//         new Solution()
//           .smallestRange(
//             Arrays.asList(
//               Arrays.asList(4, 10, 15, 24, 26),
//               Arrays.asList(0, 9, 12, 20),
//               Arrays.asList(5, 18, 22, 30)
//             )
//           )
//       )
//     );
//   }
// }

import java.util.*;

class Solution {

  public int[] smallestRange(List<List<Integer>> nums) {
    int n = nums.size();
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    int maxVal = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int val = nums.get(i).get(0);
      heap.offer(new int[] { val, i, 0 });
      maxVal = Math.max(maxVal, val);
    }

    int[] indices = new int[] { heap.peek()[0], maxVal };

    while (true) {
      int[] cur = heap.poll();
      int minVal = cur[0];
      int listIdx = cur[1];
      int elemIdx = cur[2];

      if (maxVal - minVal < indices[1] - indices[0]) {
        indices[0] = minVal;
        indices[1] = maxVal;
      }

      if (elemIdx + 1 == nums.get(listIdx).size()) break;
      int nextVal = nums.get(listIdx).get(elemIdx + 1);

      heap.offer(new int[] { nextVal, listIdx, elemIdx + 1 });
      maxVal = Math.max(maxVal, nextVal);
    }

    return indices;
  }
}

public class _632_Smallest_Range_Covering_Elements_from_K_Lists {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution()
          .smallestRange(
            Arrays.asList(
              Arrays.asList(4, 10, 15, 24, 26),
              Arrays.asList(0, 9, 12, 20),
              Arrays.asList(5, 18, 22, 30)
            )
          )
      )
    );
  }
}
