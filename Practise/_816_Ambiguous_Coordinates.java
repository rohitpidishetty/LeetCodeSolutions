import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<String> ambiguousCoordinates(String s) {
    s = s.substring(1, s.length() - 1);
    int n = s.length();

    List<String> result = new ArrayList<>();

    for (int i = 1; i < n; i++) {
      result.addAll(solve(s.substring(0, i), s.substring(i)));
    }
    return result;
  }

  private List<String> markDots(String coord) {
    int n = coord.length();
    List<String> buffer = new ArrayList<>();
    buffer.add(coord);
    for (int i = 1; i < n; i++) buffer.add(
      coord.substring(0, i) + "." + coord.substring(i)
    );
    return buffer;
  }

  private List<String> solve(String coordX, String coordY) {
    List<String> result = new ArrayList<>();

    List<String> coordsX = markDots(coordX);
    List<String> coordsY = markDots(coordY);

    for (String x : coordsX) {
      if (isValid(x)) {
        for (String y : coordsY) {
          if (isValid(y)) {
            result.add("(" + x + ", " + y + ")");
          }
        }
      }
    }
    return result;
  }

  private boolean isValid(String s) {
    if (s.contains(".")) {
      String[] parts = s.split("\\.");
      if (parts[0].length() > 1 && parts[0].startsWith("0")) return false;
      if (parts[1].endsWith("0")) return false;
    } else if (s.length() > 1 && s.startsWith("0")) return false;
    return true;
  }
}

public class _816_Ambiguous_Coordinates {

  public static void main(String[] args) {
    System.out.println(new Solution().ambiguousCoordinates("(00011)"));
  }
}
