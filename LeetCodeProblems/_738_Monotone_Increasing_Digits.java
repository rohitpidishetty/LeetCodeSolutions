class Solution {

  public int monotoneIncreasingDigits(int n) {
    int temp = n;
    char N[] = String.valueOf(n).toCharArray();
    n = N.length;
    char previous = '0';
    for (int i = 0; i < n; i++) {
      char ch = N[i];
      if (ch >= previous) previous = ch;
      else {
        N[i] = ch;
        while (i > 0 && N[i] < N[i - 1]) {
          N[i - 1] = (char) (N[i - 1] - 1);
          i--;
        }
        i++;
        while (i < n) N[i++] = '9';
        return Integer.parseInt(new String(N));
      }
    }
    return temp;
  }
}

public class _738_Monotone_Increasing_Digits {

  public static void main(String[] args) {
    System.out.println(new Solution().monotoneIncreasingDigits(31));
  }
}
