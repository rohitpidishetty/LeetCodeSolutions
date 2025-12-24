import java.util.*;

class Solution {

  public int[] findErrorNums(int[] nums) {
    int n = nums.length;
    int[] buffer = new int[n];
    for (int i = 0; i < n; i++) buffer[nums[i] - 1]++;
    List<Integer> buf = new ArrayList<>();
    for (int i = 0; i < n; i++) if (buffer[i] == 2) buf.add(i + 1);
    for (int i = 0; i < n; i++) if (buffer[i] == 0) buf.add(i + 1);
    return buf.stream().mapToInt(i -> i).toArray();
  }
}

public class _645_Set_Mismatch {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(new Solution().findErrorNums(new int[] { 2, 2 }))
    );
  }
}
