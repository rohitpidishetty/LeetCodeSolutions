// import java.util.*;

// class Solution {

//   public int findSubstringInWraproundString(String s) {
//     int n = s.length();
//     Set<String> unique = new HashSet<>();

//     for (int i = 0; i < n; i++) {
//       Stack<Character> stack = new Stack<>();
//       stack.push(s.charAt(i));
//       unique.add(String.valueOf(s.charAt(i)));
//       System.out.println(stack);

//       for (int j = i + 1; j < n; j++) {
//         char prev = s.charAt(j - 1);
//         char curr = s.charAt(j);

//         if ((curr - prev + 26) % 26 == 1) {
//           stack.push(curr);
//           unique.add(s.substring(i, j + 1));

//         } else
//           break;

//       }

//     }

//     return unique.size();
//   }
// }

// public class _467_Unique_Substrings_in_Wraparound_String {

//   public static void main(String[] args) {
//     System.out.println("Count = " + new Solution().findSubstringInWraproundString("zab"));
//   }
// }
// //
import java.util.Stack;

class Solution {

  public int findSubstringInWraproundString(String s) {
    int n = s.length();
    int sub_string_endings[] = new int[26];
    int x = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (i > 0 && ((ch - s.charAt(i - 1) + 26) % 26) == 1) x++;
      else x = 1;
      int idx = ch - 'a';
      sub_string_endings[idx] = Math.max(sub_string_endings[idx], x);
      // System.out.println(ch + " " + x);
    }
    int total = 0;
    for (int i : sub_string_endings) total += i;
    return total;
  }
}

public class _467_Unique_Substrings_in_Wraparound_String {

  public static void main(String[] args) {
    System.out.println(new Solution().findSubstringInWraproundString("zabab"));
  }
}
