import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {

  private int totalPoints = 0;
  private List<Integer> limts;
  private Random rand;
  private List<Integer> rects;
  private int[][] _rects_;

  public Solution(int[][] rects) {
    this.limts = new ArrayList<>();
    this.rects = new ArrayList<>();
    this._rects_ = rects;
    this.rand = new Random();
    for (int[] rect : rects) {
      int rect_pts = (Math.abs(rect[0] - rect[2]) + 1) * (Math.abs(rect[1] - rect[3]) + 1);
      this.rects.add(rect_pts);
      this.totalPoints += rect_pts;
      this.limts.add(this.totalPoints);
    }
  }

  public int[] pick() {
    int point = this.rand.nextInt(this.totalPoints);
    int low = 0, high = limts.size() - 1, mid = 0;
    while (low < high) {
      mid = (low + high) / 2;
      if (point >= this.limts.get(mid))
        low = mid + 1;
      else
        high = mid;
    }
    int targetBlock = low;
    int offset = point - (this.limts.get(targetBlock) - this.rects.get(targetBlock));
    int W = Math.abs(this._rects_[targetBlock][0] - this._rects_[targetBlock][2]) + 1;
    return new int[] { this._rects_[targetBlock][0] + offset % W,
        this._rects_[targetBlock][1] + offset / W };
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
public class _497_Random_Point_in_Non_overlapping_Rectangles {
  public static void main(String[] args) {
    Solution o = new Solution(new int[][] { { -2, -2, 1, 1 }, { 2, 2, 4, 6 }, { 6, 6, 8, 7 } });
    System.out.println(Arrays.toString(o.pick()));
  }
}
