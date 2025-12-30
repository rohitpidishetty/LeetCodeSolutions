import java.util.HashSet;
import java.util.Set;

class Solution {

  Set<Integer> primes = new HashSet<>(Set.of(2, 3, 5, 7, 11, 13, 17, 19));

  public int countPrimeSetBits(int left, int right) {
    int count = 0;
    for (int i = left; i <= right; i++) {
      if (primes.contains(Integer.bitCount(i))) count++;
    }
    return count;
  }
}

public class _762_Prime_Number_of_Set_Bits_in_Binary_Representation {

  public static void main(String[] args) {
    System.out.println(new Solution().countPrimeSetBits(6, 10));
  }
}
