import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int subarrayBitwiseORs(int[] arr) {
    Set<Integer> a = new HashSet<>();
    Set<Integer> temp = new HashSet<>();
    Set<Integer> res = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      for (int x : a) {
        temp.add(arr[i] | x);
        res.add(arr[i] | x);
      }
      temp.add(arr[i]);
      res.add(arr[i]);
      a = new HashSet<>(temp);
      temp.clear();
    }
    return res.size();
  }
}

public class _898_Bitwise_ORs_of_Subarrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().subarrayBitwiseORs(new int[] { 1, 1, 2 })
    );
  }
}
