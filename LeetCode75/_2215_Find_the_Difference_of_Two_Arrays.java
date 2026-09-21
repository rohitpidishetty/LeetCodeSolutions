import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> A = new HashSet<>();
    Set<Integer> B = new HashSet<>();
    for (int num : nums1) A.add(num);
    for (int num : nums2) B.add(num);
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());
    res.add(new ArrayList<>());
    for (int num : nums1)
      if (!B.contains(num) && res.get(0).contains(num) == false) res
        .get(0)
        .add(num);
    for (int num : nums2)
      if (!A.contains(num) && res.get(1).contains(num) == false) res
        .get(1)
        .add(num);

    return res;
  }
}

public class _2215_Find_the_Difference_of_Two_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findDifference(
        new int[] { 1, 2, 3 },
        new int[] { 2, 4, 6 }
      )
    );
  }
}
