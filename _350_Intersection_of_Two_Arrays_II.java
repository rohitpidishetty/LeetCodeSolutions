import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0;
    List<Integer> buffer = new ArrayList<>();
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        buffer.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) i++;
      else if (nums1[i] > nums2[j]) j++;
    }
    int[] buf = new int[buffer.size()];
    int idx = 0;
    while (idx < buf.length) {
      buf[idx] = buffer.get(idx);
      idx++;
    }
    return buf;
  }
}

public class _350_Intersection_of_Two_Arrays_II {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })
      )
    );
  }
}
