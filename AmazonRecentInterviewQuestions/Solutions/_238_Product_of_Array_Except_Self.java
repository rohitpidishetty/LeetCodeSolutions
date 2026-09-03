import java.util.Arrays;

class Solution {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int preProducts[] = new int[n];
    int postProducts[] = new int[n];
    int ans[] = new int[n];
    preProducts[0] = 1;
    postProducts[n - 1] = 1;

    /**
     * [1,2,3,4]
     * [1,1,2,6]
     * [24,12,6,1]
     */
    for (int i = 1; i < n; i++) {
      preProducts[i] = nums[i - 1] * preProducts[i - 1];
    }

    for (int i = n - 2; i >= 0; i--) {
      postProducts[i] = postProducts[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
      ans[i] = preProducts[i] * postProducts[i];
    }
    return ans;
  }
}

public class _238_Product_of_Array_Except_Self {

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        new Solution().productExceptSelf(new int[] { 1, 2, 3, 4 })
      )
    );
  }
}
