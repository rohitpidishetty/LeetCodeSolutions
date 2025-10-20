class Solution {
  public boolean checkPerfectNumber(int num) {
    int i = 1;
    int sum = 0;
    while (i < num) {
      if (num % i == 0)
        sum += i;
      i++;
      if (sum > num)
        return false;
    }
    return num == sum;
  }
}

public class _507_Perfect_Number {
  public static void main(String[] args) {
    System.out.println(new Solution().checkPerfectNumber(493));
  }
}
