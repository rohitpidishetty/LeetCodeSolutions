class Solution {

  // MLE 15 / 55 testcases passed
  // public int kthGrammar(int n, int k) {
  //   int i = 1;
  //   StringBuilder stream = new StringBuilder();
  //   while (i <= n) {
  //     if (i == 1) stream.append('0');
  //     else {
  //       if (i % 2 == 0) {
  //         StringBuilder neg = new StringBuilder();
  //         int m = stream.length();
  //         for (int j = 0; j < m; j++) {
  //           neg.append(stream.charAt(j) == '0' ? '1' : '0');
  //         }
  //         stream.append(neg);
  //       } else stream.append(new StringBuilder(stream.toString()).reverse());
  //     }
  //     i++;
  //   }
  //   int m = stream.length();
  //   for (int j = 0; j < m; j++) if (j == k - 1) return stream.charAt(j) == '0'
  //     ? 0
  //     : 1;
  //   return 0;
  // }

  public int kthGrammar(int n, int k) {
    if (n == 1 && k == 1) return 0;
    int mid = (int) Math.pow(2, n - 1) / 2;

    if (k <= mid) return kthGrammar(n - 1, k);
    return 1 - kthGrammar(n - 1, k - mid);
  }
}

public class _779_K_th_Symbol_in_Grammar {

  public static void main(String[] args) {
    System.out.println(new Solution().kthGrammar(2, 2));
  }
}
