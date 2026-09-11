import java.util.Arrays;

class Solution {

  public int minimumPushes(String word) {
    int[] freq = new int[26];
    int n = word.length();
    for (int i = 0; i < n; i++) freq[word.charAt(i) - 'a']++;
    Arrays.sort(freq);
    int total = 0;
    int partition = 0;
    for (int i = 25; i > -1; i--) total += ((partition++ / 8) + 1) * freq[i];
    return total;
  }
}

public class _3016_Minimum_Number_of_Pushes_to_Type_Word_II {

  public static void main(String[] args) {
    System.out.println(new Solution().minimumPushes("xyzxyzxyzxyz"));
  }
}
