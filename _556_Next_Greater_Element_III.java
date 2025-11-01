import java.util.Arrays;

class Solution {
  // public int nextGreaterElement(int n) {
  // char[] buffer = String.valueOf(n).toCharArray();

  // int i = buffer.length - 1, j = i;
  // boolean j_found = false;
  // while (i > -1) {
  // if (i > 0 && buffer[i] > buffer[i - 1]) {
  // while (j > -1 && buffer[j] < buffer[i - 1]) {
  // j_found = true;
  // j--;
  // }
  // if (j_found) {
  // char temp = buffer[i - 1];
  // buffer[i - 1] = buffer[j];
  // buffer[j] = temp;
  // int k = i;
  // int l = j - 1;
  // while (k <= l) {
  // temp = buffer[k];
  // buffer[k] = buffer[l];
  // buffer[l] = temp;
  // k++;
  // l--;
  // }
  // break;
  // }

  // }
  // i--;
  // }
  // long num = Long.parseLong(new String(buffer));
  // return (num > n && num < Math.pow(2, 31)) ? (int) num : -1;
  // }

  public int nextGreaterElement(int n) {
    char[] arr = String.valueOf(n).toCharArray();
    int len = arr.length;

    int i = len - 2;
    while (i >= 0 && arr[i] >= arr[i + 1])
      i--;

    if (i < 0)
      return -1;

    int j = len - 1;
    while (arr[j] <= arr[i])
      j--;

    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    int left = i + 1, right = len - 1;
    while (left < right) {
      temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }

    long num = Long.parseLong(new String(arr));
    return (num <= Integer.MAX_VALUE) ? (int) num : -1;
  }

}

public class _556_Next_Greater_Element_III {
  public static void main(String[] args) {
    System.out.println(new Solution().nextGreaterElement(12));
  }
}
