class Solution {

  public int mirrorReflection(int p, int q) {
    while (p % 2 == 0 && q % 2 == 0) {
      p /= 2;
      q /= 2;
    }
    if (p % 2 != 0 && q % 2 == 0) return 0;
    if (p % 2 != 0 && q % 2 != 0) return 1;
    if (p % 2 == 0 && q % 2 != 0) return 2;
    return -1;
  }
}

public class _858_Mirror_Reflection {

  public static void main(String[] args) {
    System.out.println(new Solution().mirrorReflection(2, 1));
  }
}
