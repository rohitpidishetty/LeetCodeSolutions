class Solution {

  public String shiftingLetters(String s, int[] shifts) {
    StringBuilder sb = new StringBuilder();

    long plus = 0;
    int n = s.length() - 1;
    int additional = 0;
    sb.append((char) (((s.charAt(n) - 97 + (shifts[n])) % 26) + 97));
    for (int i = n - 1; i >= 0; i--) {
      plus = (shifts[i] + shifts[i + 1]) % 26;
      sb.append((char) (((s.charAt(i) - 97 + (plus)) % 26) + 97));
      shifts[i] = (int) plus;
    }
    return sb.reverse().toString();
  }
}

public class _848_Shifting_Letters {

  public static void main(String[] args) {
    System.out.println(
      new Solution().shiftingLetters("abc", new int[] { 3, 5, 9 })
    );
    System.out.println(
      new Solution().shiftingLetters("aaa", new int[] { 1, 2, 3 })
    );

    System.out.println(
      new Solution().shiftingLetters("bad", new int[] { 10, 20, 30 })
    );

    System.out.println(
      new Solution().shiftingLetters("ruu", new int[] { 26, 9, 17 })
    );

    System.out.println(
      new Solution().shiftingLetters("ktmq", new int[] { 10, 26, 8, 2 })
    );

    System.out.println(
      new Solution().shiftingLetters(
        "mkgfzkkuxownxvfvxasy",
        new int[] {
          505870226,
          437526072,
          266740649,
          224336793,
          532917782,
          311122363,
          567754492,
          595798950,
          81520022,
          684110326,
          137742843,
          275267355,
          856903962,
          148291585,
          919054234,
          467541837,
          622939912,
          116899933,
          983296461,
          536563513,
        }
      )
    );
  }
}
