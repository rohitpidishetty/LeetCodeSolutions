class Solution {
  public int findComplement(int num) {
    int comp = 0;
    int i = 31;
    while (((((1 << i) & num) == 0) ? 0 : 1) != 1)
      i--;
    for (; i >= 0; i--)
      comp |= ((((1 << i) & num) == 0 ? 1 : 0) << i);
    return comp;
  }
}

public class _476_Number_Complement {
  public static void main(String[] args) {
    System.out.println(new Solution().findComplement(5));
  }
}
