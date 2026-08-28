import java.util.Arrays;

class Solution {

  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int min = Math.min(v1.length, v2.length);
    int i = 0;
    for (i = 0; i < min; i++) {
      int x = Integer.parseInt(v1[i]);
      int y = Integer.parseInt(v2[i]);
      if (x > y) return 1;
      else if (x < y) return -1;
    }
    if (v1.length > v2.length) {
      while (i < v1.length) if (Integer.parseInt(v1[i++]) > 0) return 1;
    } else if (v1.length < v2.length) {
      while (i < v2.length) if (Integer.parseInt(v2[i++]) > 0) return -1;
    }
    return 0;
  }
}

public class _165_Compare_Version_Numbers {

  public static void main(String[] args) {
    System.out.println(new Solution().compareVersion("1.2", "1.02.01"));
  }
}
