class Solution {

  public int hIndex(int[] citations) {
    int h_idx = citations.length - 1;
    int l_idx = 0;
    while (l_idx <= h_idx) {
      int m_idx = (h_idx + l_idx) / 2;
      if (citations[m_idx] >= citations.length - m_idx) h_idx = m_idx - 1;
      else l_idx = m_idx + 1;
    }
    return citations.length - l_idx;
  }
}

public class _275_H_Index_II {

  public static void main(String[] args) {
    System.out.println(new Solution().hIndex(new int[] { 1, 5, 6, 7, 8 }));
  }
}
