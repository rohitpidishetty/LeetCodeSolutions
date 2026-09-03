import java.util.HashMap;
import java.util.Map;

class Solution {

  public int totalFruit(int[] fruits) {
    Map<Integer, Integer> buckets = new HashMap<>();
    int j = 0;
    int globalMax = 0;
    for (int i = 0; i < fruits.length; i++) {
      if (!buckets.containsKey(fruits[i])) {
        while (j < i && buckets.size() == 2) {
          int reduce = buckets.get(fruits[j]) - 1;
          if (reduce == 0) buckets.remove(fruits[j]);
          else buckets.put(fruits[j], reduce);
          j++;
        }
      }
      buckets.put(fruits[i], buckets.getOrDefault(fruits[i], 0) + 1);

      globalMax = Math.max(globalMax, i - j + 1);
    }
    return globalMax;
  }
}

public class _904_Fruit_Into_Baskets {

  public static void main(String[] args) {
    System.out.println(new Solution().totalFruit(new int[] { 0, 1, 2, 2 }));
  }
}
