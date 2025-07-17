import java.util.ArrayList;
import java.util.List;

class Solution {

  private void add(List<String> buffer, String value) {
    String values = new String("0");
    int setIndex = 0;
    for (int i = 0; i < buffer.size(); i++) {
      buffer.add(i, value);
      StringBuilder sb = new StringBuilder();
      for (String s : buffer) sb.append(s);
      if (sb.toString().compareTo(values) > 0) setIndex = i;
      values = (sb.toString().compareTo(values)) > 0 ? sb.toString() : values;
      buffer.remove(i);
    }
    buffer.addLast(value);
    StringBuilder sb = new StringBuilder();
    for (String s : buffer) sb.append(s);
    if (sb.toString().compareTo(values) > 0) setIndex = buffer.size() - 1;
    buffer.removeLast();
    buffer.add(setIndex, value);
  }

  public String largestNumber(int[] nums) {
    String[] numbers = new String[nums.length - 1];
    int i = 1;
    for (; i < nums.length; i++) numbers[i - 1] = String.valueOf(nums[i]);
    List<String> buffer = new ArrayList<>();
    buffer.add(String.valueOf(nums[0]));
    for (String num : numbers) add(buffer, num);

    StringBuilder sb = new StringBuilder();
    for (String s : buffer) sb.append(s);

    return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
  }
}

public class _179_Largest_Number {

  public static void main(String[] args) {
    System.out.println(
      new Solution().largestNumber(new int[] { 3, 30, 34, 5, 9 })
    );
  }
}
