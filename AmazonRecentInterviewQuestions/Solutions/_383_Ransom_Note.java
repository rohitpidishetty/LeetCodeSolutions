import java.util.Arrays;

class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    int rn_len = ransomNote.length();
    int[] m1 = new int[26];
    int m_len = magazine.length();
    int m2[] = new int[26];
    for (int i = 0; i < rn_len; i++) m1[ransomNote.charAt(i) - 'a']++;
    for (int i = 0; i < m_len; i++) {
      char ch = magazine.charAt(i);
      if (m1[ch - 'a'] != 0) {
        m2[ch - 'a'] = Math.min(m2[ch - 'a'] + 1, m1[ch - 'a']);
      }
    }
    return Arrays.equals(m1, m2);
  }
}

public class _383_Ransom_Note {

  public static void main(String[] args) {
    System.out.println(
      new Solution().canConstruct(
        "bg",
        "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"
      )
    );
  }
}
