class Solution {

  public int peakIndexInMountainArray(int[] arr) {
    int l = 0,
      r = arr.length - 1;
    while (l < r) {
      int m = (l + r) / 2;
      if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) return m;
      else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) l = m;
      else if (arr[m] < arr[m - 1] && arr[m] > arr[m + 1]) r = m;
    }
    return l;
  }
}

public class _852_Peak_Index_in_a_Mountain_Array {

  public static void main(String[] args) {
    System.out.println(
      new Solution().peakIndexInMountainArray(new int[] { 0, 10, 5, 2 })
    );
  }
}
