import java.util.Arrays;

class Solution {

  public int countPrimes(int n) {
    // int count = 0;
    // int number = 2;
    // while (number <= n) {
    //   int deno = 2;
    //   boolean status = true;
    //   while (deno < number) {
    //     if (number % deno == 0) {
    //       status = false;
    //       break;
    //     }
    //     deno++;
    //   }
    //   if (status) count++;
    //   number++;
    // }
    // return count;

    int count = 0;
    int[] bucket = new int[n];
    System.out.println(Arrays.toString(bucket));
    for (int i = 2; i < bucket.length; i++) bucket[i] = 1;
    for (int i = 2; i * i < bucket.length; i++) {
      for (int j = i * i; j < bucket.length; j += i) {
        if (bucket[j] != 0) bucket[j] = 0;
      }
    }

    for (int i = 0; i < bucket.length; i++) if (bucket[i] == 1) count++;

    return count;
  }
}

public class _204_Count_Primes {

  public static void main(String[] args) {
    System.out.println(new Solution().countPrimes(499979));
  }
}
