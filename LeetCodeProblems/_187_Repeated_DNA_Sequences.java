import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public List<String> findRepeatedDnaSequences(String s) {
    int i = 0;
    List<String> seqs = new ArrayList<>();
    Set<String> subSeqs = new HashSet<>();
    while (i < s.length() - 10) {
      String seq = s.subSequence(i, i + 10).toString();
      if (subSeqs.contains(seq) && !seqs.contains(seq)) seqs.add(seq);
      else subSeqs.add(seq);
      i++;
    }
    return seqs;
  }
}

public class _187_Repeated_DNA_Sequences {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
    );
  }
}
