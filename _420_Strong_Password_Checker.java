import java.util.Arrays;

class Solution {

  public int strongPasswordChecker(String s) {
    int n = s.length();

    // 1) Check missing character types
    boolean lower = false, upper = false, digit = false;
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) lower = true;
      else if (Character.isUpperCase(c)) upper = true;
      else if (Character.isDigit(c)) digit = true;
    }
    int missing = 0;
    if (!lower) missing++;
    if (!upper) missing++;
    if (!digit) missing++;

    // 2) Collect runs of identical characters
    int[] runs = new int[n]; // worst-case every char is separate
    int idx = 0;
    char[] cs = s.toCharArray();
    for (int i = 0; i < n;) {
      int j = i;
      while (j < n && cs[j] == cs[i]) j++;
      runs[idx++] = j - i;
      i = j;
    }

    // 3) Count initial replacements required for runs (len/3)
    int replace = 0;
    for (int k = 0; k < idx; k++) {
      if (runs[k] >= 3) replace += runs[k] / 3;
    }

    // 4) Handle short and acceptable length cases
    if (n < 6) {
      return Math.max(missing, 6 - n); // need insertions or type fixes
    }
    if (n <= 20) {
      return Math.max(missing, replace); // only replacements needed
    }

    // 5) n > 20: deletions required. Use them greedily to reduce replacements
    int delete = n - 20;
    int toDelete = delete;

    // (a) First reduce runs where len % 3 == 0 (1 deletion reduces a replacement)
    for (int k = 0; k < idx && toDelete > 0; k++) {
      if (runs[k] < 3) continue;
      if (runs[k] % 3 == 0) {
        runs[k]--;
        toDelete--;
        replace--; // one less replacement needed
      }
    }

    // (b) Then reduce runs where len % 3 == 1 (2 deletions reduce a replacement)
    for (int k = 0; k < idx && toDelete > 0; k++) {
      if (runs[k] < 3) continue;
      if (runs[k] % 3 == 1 && runs[k] > 2) {
        int need = Math.min(2, toDelete);
        runs[k] -= need;
        toDelete -= need;
        if (need == 2) replace--; // reduced one replacement
      }
    }

    // (c) Finally apply remaining deletions to reduce larger runs (each 3 deletions reduces one replacement)
    for (int k = 0; k < idx && toDelete > 0; k++) {
      if (runs[k] < 3) continue;
      int canRemove = Math.min(runs[k] - 2, toDelete); // keep run >=2 (no further replacements)
      // Each 3 removed reduces one replacement
      replace -= canRemove / 3;
      runs[k] -= canRemove;
      toDelete -= canRemove;
    }

    return delete + Math.max(missing, Math.max(replace, 0));
  }
}

public class _420_Strong_Password_Checker {

  public static void main(String[] args) {
    System.out.println(
      new Solution().strongPasswordChecker("aaaaAAAAAA000000123456")
    );
  }
}
