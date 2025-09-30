import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  private class Mutation {

    protected String mutation;
    protected int level;

    public Mutation(String mutation, int level) {
      this.mutation = mutation;
      this.level = level;
    }
  }

  public int minMutation(String startGene, String endGene, String[] bank) {
    if (bank.length == 0) return -1;
    Set<String> visited = new HashSet<>();
    Queue<Mutation> bfsQ = new ArrayDeque<>();
    Set<String> geneBank = new HashSet<>();
    for (String gene : bank) geneBank.add(gene);
    if (!geneBank.contains(endGene)) return -1;
    int n = startGene.length() - 1;
    visited.add(startGene);
    bfsQ.offer(new Mutation(startGene, 0));
    char[] genes = { 'A', 'C', 'G', 'T' };
    while (!bfsQ.isEmpty()) {
      int current_queue_size = bfsQ.size();
      for (int i = 0; i < current_queue_size; i++) {
        Mutation mObj = bfsQ.poll();
        if (mObj.mutation.equals(endGene)) return mObj.level;
        char[] buffer = mObj.mutation.toCharArray();
        for (int pos = n; pos >= 0; pos--) {
          for (char gene : genes) {
            char[] newBuf = buffer.clone();
            newBuf[pos] = gene;
            if (buffer[pos] == gene) continue;
            String mutation = new String(newBuf);
            if (!visited.contains(mutation) && geneBank.contains(mutation)) {
              bfsQ.add(new Mutation(mutation, mObj.level + 1));
              visited.add(mutation);
            }
          }
        }
      }
    }
    return -1;
  }
}

public class _433_Minimum_Genetic_Mutation {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" })
    );
  }
}
