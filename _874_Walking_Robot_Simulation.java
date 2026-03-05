import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Solution {

  private char getDirection(char x, char y) {
    if (x == 'n' && y == 'r') return 'e';
    else if (x == 'n' && y == 'l') return 'w';
    else if (x == 's' && y == 'r') return 'w';
    else if (x == 's' && y == 'l') return 'e';
    else if (x == 'e' && y == 'l') return 'n';
    else if (x == 'e' && y == 'r') return 's';
    else if (x == 'w' && y == 'r') return 'n';
    return 's';
  }

  public int robotSim(int[] commands, int[][] obstacles) {
    Map<Integer, TreeSet<Integer>> row = new HashMap<>();
    Map<Integer, TreeSet<Integer>> col = new HashMap<>();
    for (int obstacle[] : obstacles) {
      row.computeIfAbsent(obstacle[0], e -> new TreeSet<>()).add(obstacle[1]);
      col.computeIfAbsent(obstacle[1], e -> new TreeSet<>()).add(obstacle[0]);
    }

    char direction = 'n';
    int i_coord = 0;
    int j_coord = 0;
    Integer obstacle = null;
    int new_j, new_i;
    int max = 0;
    for (int i = 0; i < commands.length; i++) {
      if (commands[i] == -1) {
        direction = getDirection(direction, 'r');
        continue;
      }
      if (commands[i] == -2) {
        direction = getDirection(direction, 'l');
        continue;
      }
      switch (direction) {
        case 'n':
          new_j = j_coord + commands[i];
          if (!row.containsKey(i_coord)) j_coord = new_j;
          else {
            obstacle = row.get(i_coord).ceiling(j_coord + 1);
            if (obstacle != null && obstacle <= new_j) j_coord = obstacle - 1;
            else j_coord = new_j;
          }
          break;
        case 's':
          new_j = j_coord - commands[i];
          if (!row.containsKey(i_coord)) j_coord = new_j;
          else {
            obstacle = row.get(i_coord).floor(j_coord - 1);
            if (obstacle != null && obstacle >= new_j) j_coord = obstacle + 1;
            else j_coord = new_j;
          }
          break;
        case 'e':
          new_i = i_coord + commands[i];
          if (!col.containsKey(j_coord)) i_coord = new_i;
          else {
            obstacle = col.get(j_coord).ceiling(i_coord + 1);
            if (obstacle != null && obstacle <= new_i) i_coord = obstacle - 1;
            else i_coord = new_i;
          }
          break;
        case 'w':
          new_i = i_coord - commands[i];
          if (!col.containsKey(j_coord)) i_coord = new_i;
          else {
            obstacle = col.get(j_coord).floor(i_coord - 1);
            if (obstacle != null && obstacle >= new_i) i_coord = obstacle + 1;
            else i_coord = new_i;
          }
          break;
      }
      max = Math.max(max, (i_coord * i_coord) + (j_coord * j_coord));
    }

    return max;
  }
}

public class _874_Walking_Robot_Simulation {

  public static void main(String[] args) {
    System.out.println(
      new Solution().robotSim(
        new int[] { 4, -1, 4, -2, 4 },
        new int[][] { { 2, 4 } }
      )
    );
  }
}
