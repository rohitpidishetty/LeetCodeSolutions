import java.util.Arrays;

class Solution {

  // 57 / 59 testcases passed
  // public String findReplaceString(
  //   String s,
  //   int[] indices,
  //   String[] sources,
  //   String[] targets
  // ) {
  //   StringBuilder sb = new StringBuilder();
  //   int n = s.length();
  //   int pointer = 0;
  //   Object[][] data = new Object[indices.length][4];
  //   for (int i = 0; i < indices.length; i++) {
  //     data[i] = new Object[] { indices[i], sources[i], targets[i], i };
  //   }
  //   Arrays.sort(data, (a, b) -> {
  //     int cmp = (int) a[0] - (int) b[0];
  //     if (cmp != 0) return cmp;
  //     return (int) b[3] - (int) a[3];
  //   });
  //   for (int i = 0; i < data.length; i++) {
  //     indices[i] = (int) data[i][0];
  //     sources[i] = data[i][1].toString();
  //     targets[i] = data[i][2].toString();
  //   }
  //   System.out.println(Arrays.deepToString(data));
  //   for (int i = 0; i < n; ) {
  //     if (pointer < indices.length && i == indices[pointer]) {
  //       String source = sources[pointer];
  //       int m = source.length();
  //       if (i + m <= n && s.substring(i, i + m).equals(source)) {
  //         sb.append(targets[pointer]);
  //         i += m;
  //       } else {
  //         sb.append(s.charAt(i));
  //         i++;
  //       }
  //       pointer++;
  //     } else {
  //       sb.append(s.charAt(i));
  //       i++;
  //     }
  //   }
  //   return sb.toString();
  // }

  public String findReplaceString(
    String s,
    int[] indices,
    String[] sources,
    String[] targets
  ) {
    int n = indices.length;
    Integer[] order = new Integer[n];
    for (int i = 0; i < n; i++) order[i] = i;

    Arrays.sort(order, (a, b) -> indices[a] - indices[b]);

    StringBuilder sb = new StringBuilder();
    int prev = 0;

    for (int i = 0; i < n; i++) {
      int idx = indices[order[i]];
      String src = sources[order[i]];
      String tgt = targets[order[i]];
      if (idx < prev) continue;
      sb.append(s, prev, idx);
      if (s.startsWith(src, idx)) {
        sb.append(tgt);
        prev = idx + src.length();
      } else prev = idx;
    }
    sb.append(s.substring(prev));
    return sb.toString();
  }
}

public class _833_Find_And_Replace_in_String {

  public static void main(String[] args) {
    System.out.println(
      new Solution().findReplaceString(
        "abcd",
        new int[] { 0, 2 },
        new String[] { "a", "cd" },
        new String[] { "eee", "ffff" }
      )
    );
    System.out.println(
      new Solution().findReplaceString(
        "abcd",
        new int[] { 0, 2 },
        new String[] { "ab", "ec" },
        new String[] { "eee", "ffff" }
      )
    );

    System.out.println(
      new Solution().findReplaceString(
        "vmokgggqzp",
        new int[] { 3, 5, 1 },
        new String[] { "kg", "ggq", "mo" },
        new String[] { "s", "so", "bfr" }
      )
    );

    System.out.println(
      new Solution().findReplaceString(
        "jjievdtjfb",
        new int[] { 4, 6, 1 },
        new String[] { "md", "tjgb", "jf" },
        new String[] { "foe", "oov", "e" }
      )
    );

    System.out.println(
      new Solution().findReplaceString(
        "abcde",
        new int[] { 2, 2 },
        new String[] { "bc", "cde" },
        new String[] { "fe", "f" }
      )
    );
  }
}
