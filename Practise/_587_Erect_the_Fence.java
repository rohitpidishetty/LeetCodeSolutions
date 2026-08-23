
import java.util.*;

class Solution {

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3) {
            return trees;
        }

        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> outerSide = new ArrayList<>(), innerSide = new ArrayList<>();

        for (int[] p : trees) {
            while (outerSide.size() >= 2 && slopeDiff(outerSide.get(outerSide.size() - 2), outerSide.get(outerSide.size() - 1), p) > 0) {
                outerSide.remove(outerSide.size() - 1);
            }
            while (innerSide.size() >= 2 && slopeDiff(innerSide.get(innerSide.size() - 2), innerSide.get(innerSide.size() - 1), p) < 0) {
                innerSide.remove(innerSide.size() - 1);
            }
            outerSide.add(p);
            innerSide.add(p);
        }

        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int[] p : outerSide) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) {
                result.add(p);
            }
        }
        for (int[] p : innerSide) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) {
                result.add(p);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private int slopeDiff(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }
}

public class _587_Erect_the_Fence {

    public static void main(String[] args) {
        int[][] trees = {
            {1, 1},
            {2, 2},
            {2, 0},
            {2, 4},
            {3, 3},
            {4, 2}
        };

        int[][] res = new Solution().outerTrees(trees);
        for (int[] p : res) {
            System.out.println(Arrays.toString(p));
        }
    }
}
