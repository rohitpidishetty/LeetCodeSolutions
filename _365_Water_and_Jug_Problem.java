import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  private Map<String, Boolean> visited;

  private boolean solve(
    int xLevel,
    int xCap,
    int yLevel,
    int yCap,
    int target
  ) {
    String node = xLevel + "-" + yLevel;
    if (visited.containsKey(node)) return visited.get(node);
    visited.put(node, false);
    if (
      (xLevel == 0 && yLevel == target) ||
      (yLevel == 0 && xLevel == target) ||
      yLevel + xLevel == target
    ) return true;
    // Fill, Empty, Transfer
    boolean ax = solve(xCap, xCap, yLevel, yCap, target);
    boolean bx = solve(xLevel, xCap, yCap, yCap, target);
    boolean cx = solve(0, xCap, yLevel, yCap, target);
    boolean dx = solve(xLevel, xCap, 0, yCap, target);
    int _xLevel = 0;
    int _yLevel = 0;
    int xSpace = xCap - xLevel;
    if (xSpace > yLevel) {
      _xLevel = xLevel + yLevel;
      _yLevel = 0;
    } else {
      _xLevel = xCap;
      _yLevel = yLevel - xSpace;
    }
    boolean ex = solve(_xLevel, xCap, _yLevel, yCap, target);
    int ySpace = yCap - yLevel;
    if (ySpace > xLevel) {
      _yLevel = yLevel + xLevel;
      _xLevel = 0;
    } else {
      _xLevel = xLevel - ySpace;
      _yLevel = yCap;
    }
    boolean fx = solve(_xLevel, xCap, _yLevel, yCap, target);
    boolean res = (ax || bx || cx || dx || ex || fx);
    return res;
  }

  public boolean canMeasureWater(int x, int y, int target) {
    visited = new HashMap<>();
    return solve(0, x, 0, y, target);
  }
}

public class _365_Water_and_Jug_Problem {

  public static void main(String[] args) {
    System.out.println(new Solution().canMeasureWater(3, 5, 4));
  }
}
