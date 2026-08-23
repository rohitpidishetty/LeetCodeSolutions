import java.util.ArrayList;
import java.util.List;

class Solution {

  private List<String> buffer;

  public List<String> readBinaryWatch(int turnedOn) {
    buffer = new ArrayList<>();
    for (int i = turnedOn; i >= 0; i--) {
      int j = turnedOn - i;
      cross(setBit(i, 11), setBit(j, 59));
    }
    return buffer;
  }

  private void cross(List<String> x, List<String> y) {
    for (String hour : x) {
      for (String minute : y) buffer.add(hour + ":" + minute);
    }
  }

  private List<String> setBit(int numberOfSetBits, int bitStreamLength) {
    List<String> hrs = new ArrayList<>();
    for (int i = 0; i <= bitStreamLength; i++) {
      String num = String.valueOf(i);
      num = (num.length() == 1 && bitStreamLength != 11)
        ? new StringBuilder().append('0').append(num).toString()
        : new StringBuilder().append(num).toString();
      if (Integer.bitCount(i) == numberOfSetBits) hrs.add(num);
    }
    return hrs;
  }
}

public class _401_Binary_Watch {

  public static void main(String[] args) {
    System.out.println(new Solution().readBinaryWatch(1));
  }
}
