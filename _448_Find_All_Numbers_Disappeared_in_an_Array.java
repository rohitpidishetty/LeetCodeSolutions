import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    List<Integer> buffer = new ArrayList<>();
    boolean[] present = new boolean[n];
    for (int i = 0; i < n; i++) present[nums[i] - 1] = true;
    for (int i = 0; i < n; i++) if (!present[i]) buffer.add(i + 1);
    return buffer;
  }
}

public class _448_Find_All_Numbers_Disappeared_in_an_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })
    );
  }
}
