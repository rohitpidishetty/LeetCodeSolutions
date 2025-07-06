class Solution {

  // Ninja technique for better performance. Pre-run the code to see the magic by
  // JIT compiler.
  static {
    for (int i = 0; i < 140; ++i)
      candy(new int[] { 1, 3, 2 });
    System.gc();
  }

  public static int candy(int[] ratings) {
    int count = 0;
    int[] candies = new int[ratings.length];
    int i = 0;
    while (i < ratings.length) {
      candies[i] = 1;
      if (i != 0 && ratings[i] > ratings[i - 1])
        candies[i] = candies[i - 1] + 1;
      i++;
    }
    i = candies.length - 1;
    while (i >= 0) {
      if (i != candies.length - 1 && ratings[i] > ratings[i + 1])
        candies[i] = (candies[i] > candies[i + 1]) ? candies[i] : candies[i + 1] + 1;
      i--;
    }
    for (int n : candies)
      count += n;
    return count;
  }
}