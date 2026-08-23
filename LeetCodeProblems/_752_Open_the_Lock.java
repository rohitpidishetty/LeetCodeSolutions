import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {

  private class LevelOrderPayload {

    protected char[] state;
    protected int level;

    public LevelOrderPayload(char[] state, int level) {
      this.state = state;
      this.level = level;
    }
  }

  public int openLock(String[] deadends, String target) {
    char[] initialState = new char[] { '0', '0', '0', '0' };
    Set<String> block = new HashSet<>();
    for (String s : deadends) block.add(s);
    Queue<LevelOrderPayload> bfsQ = new ArrayDeque<>();
    bfsQ.add(new LevelOrderPayload(initialState, 0));
    while (!bfsQ.isEmpty()) {
      int levelLength = bfsQ.size();
      for (int l = 0; l < levelLength; l++) {
        LevelOrderPayload currentState = bfsQ.poll();
        String state = new String(currentState.state);
        if (block.contains(state)) continue;
        if (state.equals(target)) return currentState.level;
        block.add(state);
        for (int i = 0; i < 4; i++) {
          char[] clockwiseNext = Arrays.copyOf(currentState.state, 4);
          int n1 = (int) clockwiseNext[i] + 1;
          clockwiseNext[i] = (n1 > 57) ? '0' : (char) n1;
          char[] antiClockwiseNext = Arrays.copyOf(currentState.state, 4);
          int n2 = (int) antiClockwiseNext[i] - 1;
          antiClockwiseNext[i] = (n2 < 48) ? '9' : (char) n2;
          bfsQ.add(
            new LevelOrderPayload(clockwiseNext, currentState.level + 1)
          );
          bfsQ.add(
            new LevelOrderPayload(antiClockwiseNext, currentState.level + 1)
          );
        }
      }
    }
    return -1;
  }
}

public class _752_Open_the_Lock {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .openLock(
          new String[] { "0201", "0101", "0102", "1212", "2002" },
          "0202"
        )
    );
  }
}
