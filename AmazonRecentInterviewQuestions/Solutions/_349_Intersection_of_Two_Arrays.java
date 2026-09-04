import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> a = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    for (int n1 : nums1) a.add(n1);
    for (int n2 : nums2) {
      if (a.contains(n2)) {
        res.add(n2);
        a.remove(n2);
      }
    }
    int[] ans = new int[res.size()];

    for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);

    return ans;
  }
}

public class _349_Intersection_of_Two_Arrays {

  public static void main(String[] args) {
    System.out.println(
      new Solution().intersection(
        new int[] { 4, 9, 5 },
        new int[] { 9, 4, 9, 8, 4 }
      )
    );
  }
}
