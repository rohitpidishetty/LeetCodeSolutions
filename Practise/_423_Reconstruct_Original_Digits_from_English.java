// 13/24 Passed

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

// class Trie {

//   protected Trie[] buffer;
//   protected boolean isEOW;
//   protected int digit;

//   public Trie() {
//     this.buffer = new Trie[26];
//     this.isEOW = false;
//     this.digit = 0;
//   }
// }

// class Solution {

//   protected int[] present;

//   protected void dfs(
//     Trie root,
//     Map<Character, Integer> hMap,
//     Set<Character> set,
//     Character ch
//   ) {
//     if (root == null) return;
//     if (root.isEOW) {
//       present[root.digit]++;
//       return;
//     }

//     for (int i = 0; i < root.buffer.length; i++) {
//       char subCh = (char) (i + 'a');
//       if (root.buffer[i] != null && set.contains(subCh)) {
//         if (hMap.get(subCh) > 1) hMap.put(subCh, hMap.get(subCh) - 1);
//         else set.remove(subCh);
//         dfs(root.buffer[i], hMap, set, subCh);
//       }
//     }
//   }

//   public String originalDigits(String s) {
//     present = new int[10];
//     Map<Character, Integer> hMap = new HashMap<>();
//     Set<Character> set = new HashSet<>();
//     Trie root = new Trie();
//     int n = s.length();

//     // Lets first build TRIE tree
//     String[] numbers = {
//       "zero",
//       "one",
//       "two",
//       "three",
//       "four",
//       "five",
//       "six",
//       "seven",
//       "eight",
//       "nine",
//     };
//     for (int i = 0; i < numbers.length; i++) {
//       int m = numbers[i].length();
//       Trie subRoot = root;
//       for (int j = 0; j < m; j++) {
//         int chIdx = numbers[i].charAt(j) - 'a';
//         if (subRoot.buffer[chIdx] == null) subRoot.buffer[chIdx] = new Trie();
//         subRoot = subRoot.buffer[chIdx];
//       }
//       subRoot.isEOW = true;
//       subRoot.digit = i;
//     }
//     // EO: Trie Tree

//     for (int i = 0; i < n; i++) {
//       char ch = s.charAt(i);
//       hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
//       set.add(ch);
//     }

//     for (int i = 0; i < n; i++) {
//       char ch = s.charAt(i);
//       if (set.contains(ch) && root.buffer[ch - 'a'] != null) {
//         dfs(root.buffer[ch - 'a'], hMap, set, ch);
//       }
//     }

//     StringBuilder sb = new StringBuilder();

//     for (int i = 0; i < present.length; i++) {
//       for (int j = 0; j < present[i]; j++) {
//         sb.append((char) (i + '0'));
//       }
//     }

//     return sb.toString();
//   }
// }

// public class _423_Reconstruct_Original_Digits_from_English {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution().originalDigits("zeroonetwothreefourfivesixseveneightnine")
//     );
//   }
// }

class Solution {

  public String originalDigits(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;

    int[] digits = new int[10];

    digits[0] = count['z' - 'a']; // "zero"
    digits[2] = count['w' - 'a']; // "two"
    digits[4] = count['u' - 'a']; // "four"
    digits[6] = count['x' - 'a']; // "six"
    digits[8] = count['g' - 'a']; // "eight"

    digits[3] = count['h' - 'a'] - digits[8]; // "three"
    digits[5] = count['f' - 'a'] - digits[4]; // "five"
    digits[7] = count['s' - 'a'] - digits[6]; // "seven"

    digits[1] = count['o' - 'a'] - digits[0] - digits[2] - digits[4]; // "one"
    digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8]; // "nine"

    // Build result string
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 9; i++) {
      for (int j = 0; j < digits[i]; j++) sb.append(i);
    }

    return sb.toString();
  }
}

public class _423_Reconstruct_Original_Digits_from_English {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.originalDigits("owoztneoer"));
  }
}
