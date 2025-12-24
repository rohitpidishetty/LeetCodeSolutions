import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<String> fizzBuzz(int n) {
    List<String> buffer = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) buffer.add("FizzBuzz");
      else if (i % 3 == 0) buffer.add("Fizz");
      else if (i % 5 == 0) buffer.add("Buzz");
      else buffer.add(Integer.toString(i));
    }
    return buffer;
  }
}

public class _412_Fizz_Buzz {

  public static void main(String[] args) {
    System.out.println(new Solution().fizzBuzz(15));
  }
}
