import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> collec = new ArrayList<>();
    List<List<Integer>> collec2 = new ArrayList<>();
    collec.add(Arrays.asList(buildings[0][0], buildings[0][2]));
    for (int i = 1; i < buildings.length; i++) {
      if (buildings[i][0] < buildings[i - 1][1]) {
        if (buildings[i][2] > buildings[i - 1][2]) {
          collec.add(
            Arrays.asList(
              Math.max(buildings[i][0], buildings[i - 1][0]),
              Math.min(buildings[i][2], buildings[i - 1][2])
            )
          );
          collec.add(
            Arrays.asList(
              Math.max(buildings[i][0], buildings[i - 1][0]),
              Math.max(buildings[i][2], buildings[i - 1][2])
            )
          );
        } else {
          collec.add(
            Arrays.asList(
              buildings[i - 1][1],
              Math.min(buildings[i][2], buildings[i - 1][2])
            )
          );
          collec.add(
            Arrays.asList(
              buildings[i - 1][1],
              Math.max(buildings[i][2], buildings[i - 1][2])
            )
          );
        }
      } else {
        collec.add(Arrays.asList(buildings[i][0], 0));
        collec.add(Arrays.asList(buildings[i][0], buildings[i][2]));
      }
    }
    int m = buildings.length - 1;
    collec2.add(Arrays.asList(buildings[m][1], buildings[m][2]));
    for (int i = m - 1; i > -1; i--) {
      if (buildings[i][1] > buildings[i + 1][0]) {
        if (buildings[i][2] > buildings[i + 1][2]) {
          collec2.add(
            Arrays.asList(
              Math.min(buildings[i][1], buildings[i + 1][1]),
              Math.min(buildings[i][2], buildings[i + 1][2])
            )
          );
          collec2.add(
            Arrays.asList(
              Math.min(buildings[i][1], buildings[i + 1][1]),
              Math.max(buildings[i][2], buildings[i + 1][2])
            )
          );
        } else {
          collec2.add(
            Arrays.asList(
              buildings[i + 1][0],
              Math.min(buildings[i][2], buildings[i + 1][2])
            )
          );
          collec2.add(
            Arrays.asList(
              buildings[i + 1][0],
              Math.max(buildings[i][2], buildings[i + 1][2])
            )
          );
        }
      } else {
        collec2.add(Arrays.asList(buildings[i][1], 0));
        collec2.add(Arrays.asList(buildings[i][1], buildings[i][2]));
      }
    }
    Set<List<Integer>> orderedSet = new LinkedHashSet<>();
    orderedSet.addAll(collec);
    orderedSet.addAll(collec2);
    List<List<Integer>> res = new ArrayList<>(orderedSet);
    res.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

    // [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
    return null;
  }
}

public class _218_The_Skyline_Problem {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .getSkyline(
          new int[][] {
            { 2, 9, 10 },
            { 3, 7, 15 },
            { 5, 12, 12 },
            { 15, 20, 10 },
            { 19, 24, 8 },
          }
        )
    );
  }
}
