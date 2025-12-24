import java.util.Arrays;

class Solution {

  // -------------------- Initial solution --------------------
  private int solve(int[] v1, int[] v2) {
    int i = 0;
    int j = 0;
    while (i < v1.length) {
      if (v1[i] == v2[j]) {
        i++;
        j++;
      } else if (v1[i] < v2[j])
        return -1;
      else
        return 1;
    }
    return 0;
  }

  public int compareVersion(String version1, String version2) {
    int max = 0;
    String[] v1 = null;
    String[] v2 = null;
    v1 = version1.contains(".") ? version1.split("[.]") : new String[] { version1 };
    v2 = version2.contains(".") ? version2.split("[.]") : new String[] { version2 };
    max = Math.max(v1.length, v2.length);
    int[] V1 = new int[max];
    int[] V2 = new int[max];
    int i = 0;
    while (i < max) {
      V1[i] = i < v1.length ? Integer.parseInt(v1[i]) : 0;
      V2[i] = i < v2.length ? Integer.parseInt(v2[i]) : 0;
      i++;
    }
    return solve(V1, V2);
  }
  // -------------------- Sol end --------------------

}

public class __165_Compare_Version_Numbers {
  public static void main(String[] args) {
    System.out.println(new Solution().compareVersion("1.0.1", "1"));
  }
}
