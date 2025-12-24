/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {

  public int rand10() {
    int a = rand7();
    while (a > 5)
      a = rand7();
    int b = rand7();
    while (b > 6)
      b = rand7();
    if (b <= 3)
      return a;
    else
      return a + 5;
  }
}

public class _470_Implement_Rand10_Using_Rand7_ {

  public static void main(String[] args) {
    System.out.println(new Solution().rand10());
  }
}
