// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Solution {

//   class plot {
//     protected char ch;
//     protected int first_index;
//     protected int last_index;

//     public plot(char ch, int first_index, int last_index) {
//       this.ch = ch;
//       this.first_index = first_index;
//       this.last_index = last_index;
//     }
//   }

//   private Map<Integer, List<plot>> get_board_state(String board) {
//     Map<Integer, List<plot>> state = new HashMap<>();
//     int n = board.length();
//     int[] occurances = new int[n];
//     int i = 0;
//     for (; i < n; i++) {
//       char ch = board.charAt(i);
//       if (i > 0 && ch == board.charAt(i - 1))
//         occurances[i] = occurances[i - 1] + 1;
//       else {
//         if (i > 0) {
//           int occurance = occurances[i - 1];
//           if (state.get(occurance) == null)
//             state.put(occurance, new ArrayList<>());
//           state.get(occurance).add(new plot(board.charAt(i - 1), ((i - 1) - occurances[i - 1] + 1), (i - 1)));
//         }
//         occurances[i] = 1;
//       }
//     }
//     int occurance = occurances[i - 1];
//     if (state.get(occurance) == null)
//       state.put(occurance, new ArrayList<>());
//     state.get(occurance).add(new plot(board.charAt(i - 1), ((i - 1) - occurances[i - 1] + 1), (i - 1)));
//     return state;
//   }

//   private String simpleReduction(String board, List<plot> plots) {
//     plot plt = plots.get(0);
//     StringBuilder sb = new StringBuilder(board);
//     if (plt.first_index == 0) {
//       while (sb.length() > 0 && sb.charAt(0) == plt.ch)
//         sb.deleteCharAt(0);
//     } else if (plt.last_index == board.length() - 1) {
//       while (sb.length() > 0 && sb.charAt(sb.length() - 1) == plt.ch)
//         sb.deleteCharAt(sb.length() - 1);
//     } else
//       sb.delete(plt.first_index, plt.last_index + 1);
//     return sb.toString();
//   }

//   private int play(String board, Map<Character, Integer> choices) {

//     if (choices == null)
//       return 0;
//     if (choices.isEmpty())
//       return Integer.MAX_VALUE;
//     int m = board.length();
//     List<List<plot>> state_list = new BucketSort(get_board_state(board)).sort();
//     int n = state_list.size() - 1;
//     int min_moves = Integer.MAX_VALUE;
//     for (int i = n; i >= 0; i--) {
//       List<plot> plots = state_list.get(i);
//       if (plots.size() != 0) {
//         String transientBoardState = new String();
//         if (i > 2) {
//           transientBoardState = simpleReduction(board, plots);
//         } else {
//           for (plot plot : plots) {
//             Map<Character, Integer> nextChoices = new HashMap<>(choices);
//             if (nextChoices.containsKey(plot.ch)) {
//               nextChoices.put(plot.ch, nextChoices.get(plot.ch) - 1);
//               if (plot.first_index != plot.last_index) {
//                 transientBoardState = board.substring(0, plot.first_index + 1) + plot.ch
//                     + board.substring(plot.last_index);
//               } else {
//                 // Add at last
//                 if (plot.last_index == m - 1)
//                   transientBoardState = board.substring(0, plot.first_index + 1) + plot.ch;
//                 // Add at first
//                 else if (plot.first_index == 0)
//                   transientBoardState = plot.ch + board.substring(plot.first_index);
//                 else
//                   transientBoardState = board.substring(0, plot.first_index) + plot.ch
//                       + board.substring(plot.last_index);
//               }
//               min_moves = Math.min(min_moves, 1 + play(transientBoardState, nextChoices));
//             }
//           }
//         }
//       }
//     }
//     return min_moves;
//   }

//   public int findMinStep(String board, String hand) {
//     Map<Character, Integer> choices = new HashMap<>();
//     int n = hand.length();
//     for (int i = 0; i < n; i++) {
//       char ch = hand.charAt(i);
//       choices.put(ch, choices.getOrDefault(ch, 0) + 1);
//     }
//     return play(board, choices);
//   }

//   class BucketSort {
//     private List<List<plot>> buffer;

//     public BucketSort(Map<Integer, List<plot>> state) {
//       this.buffer = new ArrayList<>();
//       for (Map.Entry<Integer, List<plot>> state_obj : state.entrySet()) {
//         while (buffer.size() <= state_obj.getKey())
//           buffer.add(new ArrayList<>());
//         buffer.get(state_obj.getKey()).addAll(state_obj.getValue());
//       }
//     }

//     protected List<List<plot>> sort() {
//       return this.buffer;
//     }
//   }
// }

// public class _488_Zuma_Game {
//   public static void main(String[] args) {
//     System.out.println(new Solution().findMinStep("WWRRBBWW", "WRBRW"));
//   }
// }

import java.util.*;

class Solution {

  // Track consecutive balls
  class plot {
    protected char ch;
    protected int first_index;
    protected int last_index;

    public plot(char ch, int first_index, int last_index) {
      this.ch = ch;
      this.first_index = first_index;
      this.last_index = last_index;
    }
  }

  private Map<String, Integer> memo = new HashMap<>();

  // Shrink board recursively until no 3+ consecutive balls
  private String shrink(String board) {
    boolean changed = true;
    while (changed) {
      changed = false;
      int n = board.length();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n;) {
        int j = i;
        while (j < n && board.charAt(j) == board.charAt(i))
          j++;
        if (j - i >= 3) {
          changed = true; // remove this group
        } else {
          sb.append(board.substring(i, j));
        }
        i = j;
      }
      board = sb.toString();
    }
    return board;
  }

  // DFS function using hand map
  private int play(String board, Map<Character, Integer> choices) {
    if (board.length() == 0)
      return 0;
    if (choices.isEmpty())
      return Integer.MAX_VALUE;

    String key = board + "#" + choices.toString();
    if (memo.containsKey(key))
      return memo.get(key);

    int minMoves = Integer.MAX_VALUE;
    int n = board.length();

    for (int i = 0; i <= n; i++) { // positions to insert
      for (char c : choices.keySet()) {
        int count = choices.get(c);
        if (count == 0)
          continue;

        // insert c at position i
        String newBoard = board.substring(0, i) + c + board.substring(i);
        newBoard = shrink(newBoard);

        // use one ball of this color
        choices.put(c, count - 1);
        int steps = play(newBoard, choices);
        if (steps != Integer.MAX_VALUE)
          minMoves = Math.min(minMoves, steps + 1);
        choices.put(c, count); // backtrack
      }
    }

    memo.put(key, minMoves);
    return minMoves;
  }

  public int findMinStep(String board, String hand) {
    Map<Character, Integer> choices = new HashMap<>();
    for (char ch : hand.toCharArray())
      choices.put(ch, choices.getOrDefault(ch, 0) + 1);

    int res = play(board, choices);
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}

public class _488_Zuma_Game {
  public static void main(String[] args) {
    System.out.println(new Solution().findMinStep("WWRRBBWW", "WRBRW")); // 2
    System.out.println(new Solution().findMinStep("RRWWRRBBRR", "WB")); // 2
    System.out.println(new Solution().findMinStep("G", "GGGGG")); // 2
  }
}
