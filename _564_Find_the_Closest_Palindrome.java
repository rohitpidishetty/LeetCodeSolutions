// import java.util.Arrays;

// class Solution {
//   public String nearestPalindromic(String n) {
//     int num = Integer.parseInt(n);
//     if (num <= 11) {
//       if (num > 9)
//         return String.valueOf(9);
//       return String.valueOf(num - 1);
//     }
//     int len = n.length(), mid = len / 2;
//     String fh = n.substring(0, mid), num1 = new String(), num2 = new String(), nx = new String(), ny = new String();
//     if (len % 2 == 0) {
//       String sh = n.substring(mid);
//       num1 = fh + new StringBuilder(fh).reverse();
//       nx = String.valueOf(Integer.parseInt(fh) + 1);
//       nx += new StringBuilder(nx.substring(0, nx.length())).reverse();
//       ny = String.valueOf(Integer.parseInt(fh) - 1);
//       ny += new StringBuilder(ny.substring(0, ny.length())).reverse();

//     } else {
//       String sh = n.substring(mid + 1);
//       num1 = fh + n.charAt(mid) + new StringBuilder(fh).reverse();
//       nx = String.valueOf(Integer.parseInt(fh + n.charAt(mid)) + 1);
//       nx += new StringBuilder(nx.substring(0, nx.length() - 1)).reverse();
//       ny = String.valueOf(Integer.parseInt(fh + n.charAt(mid)) - 1);
//       ny += new StringBuilder(ny.substring(0, ny.length())).reverse();

//     }

//     int n1 = Integer.parseInt(num1);
//     int n3 = Integer.parseInt(nx);
//     int n4 = Integer.parseInt(ny);

//     int[] nums = { n1, n3, n4 };

//     int min_dist = Integer.MAX_VALUE;
//     String ret = new String();

//     for (int x : nums) {
//       int dist = Math.abs(x - num);
//       if (dist < min_dist) {
//         min_dist = dist;
//         ret = String.valueOf(x);
//       }
//     }
//     if (!ret.equals(n))
//       return ret;

//     System.out.println(n1 + " " + n3 + " " + n4);
//     return (n1 < n3 && n1 < n4) ? String.valueOf(n1) : (n3 < n1 && n3 < n4) ? String.valueOf(n3) : String.valueOf(n4);
//   }
// }

// public class _564_Find_the_Closest_Palindrome {
//   public static void main(String[] args) {
//     System.out.println(new Solution().nearestPalindromic("99"));
//   }
// }

class Solution {
  public String nearestPalindromic(String n) {
    long num = Long.parseLong(n);
    if (num <= 11) {
      if (num > 9)
        return "9";
      return String.valueOf(num - 1);
    }

    int len = n.length(), mid = len / 2;
    String fh = n.substring(0, mid);
    String num1 = "", nx = "", ny = "";

    if (len % 2 == 0) {

      num1 = fh + new StringBuilder(fh).reverse();
      String plus = String.valueOf(Long.parseLong(fh) + 1);
      nx = plus + new StringBuilder(plus).reverse();
      String minus = String.valueOf(Long.parseLong(fh) - 1);
      ny = minus + new StringBuilder(minus).reverse();
    } else {

      String middle = n.substring(mid, mid + 1);
      num1 = fh + middle + new StringBuilder(fh).reverse();

      String base = fh + middle;
      String plus = String.valueOf(Long.parseLong(base) + 1);
      nx = plus + new StringBuilder(plus.substring(0, plus.length() - 1)).reverse();

      String minus = String.valueOf(Long.parseLong(base) - 1);
      ny = minus + new StringBuilder(minus.substring(0, minus.length() - 1)).reverse();
    }

    long n1 = Long.parseLong(num1);
    long n3 = Long.parseLong(nx);
    long n4 = Long.parseLong(ny);

    long big = (long) Math.pow(10, len) + 1;
    long small = (long) Math.pow(10, len - 1) - 1;

    long[] candidates = { n1, n3, n4, big, small };

    long minDist = Long.MAX_VALUE;
    long ret = -1;

    for (long x : candidates) {
      if (x == num)
        continue;
      long dist = Math.abs(x - num);
      if (dist < minDist || (dist == minDist && x < ret)) {
        minDist = dist;
        ret = x;
      }
    }

    return String.valueOf(ret);
  }
}

public class _564_Find_the_Closest_Palindrome {
  public static void main(String[] args) {
    System.out.println(new Solution().nearestPalindromic("99"));
    System.out.println(new Solution().nearestPalindromic("88"));
    System.out.println(new Solution().nearestPalindromic("1321"));
    System.out.println(new Solution().nearestPalindromic("999"));
    System.out.println(new Solution().nearestPalindromic("1000"));
    System.out.println(new Solution().nearestPalindromic("12345"));
  }
}
