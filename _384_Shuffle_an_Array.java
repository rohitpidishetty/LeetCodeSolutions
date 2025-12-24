import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {

  private int[] originalBuffer;
  private int[] shuffledBuffer;
  private int magnitude;
  private Random random;

  public Solution(int[] nums) {
    random = new Random();
    magnitude = nums.length;
    originalBuffer = new int[magnitude];
    shuffledBuffer = new int[magnitude];
    for (int i = 0; i < magnitude; i++) {
      originalBuffer[i] = nums[i];
      shuffledBuffer[i] = nums[i];
    }
  }

  public int[] reset() {
    return originalBuffer;
  }

  public int[] shuffle() {
    Set<Integer> usedIndices = new HashSet<>();
    int[] shuffled = new int[magnitude];
    for (int i = 0; i < magnitude; i++) {
      shuffled[i] = generateIndex(usedIndices, magnitude);
    }
    return shuffled;
  }

  private int generateIndex(Set<Integer> indices, int m) {
    int rand = random.nextInt(magnitude);
    while (indices.contains(rand)) rand = random.nextInt(magnitude);
    indices.add(rand);
    return originalBuffer[rand];
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

public class _384_Shuffle_an_Array {

  public static void main(String[] args) {
    Solution obj = new Solution(new int[] { 1, 2, 3 });
    System.out.println(Arrays.toString(obj.shuffle()));
    System.out.println(Arrays.toString(obj.reset()));
  }
}
