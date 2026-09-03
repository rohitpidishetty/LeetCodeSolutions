import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int ladderLength(
    String beginWord,
    String endWord,
    List<String> wordList
  ) {
    int minDistance = 1;
    if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
    Set<String> words = new HashSet<>(wordList);

    int wordLen = beginWord.length();
    Set<String> visited = new HashSet<>();
    Queue<String> q = new ArrayDeque<>();
    q.offer(beginWord);
    visited.add(beginWord);
    while (!q.isEmpty()) {
      int n = q.size();
      while (n > 0) {
        char[] curr = q.poll().toCharArray();
        for (int i = 0; i < wordLen; i++) {
          char save = curr[i];
          for (int ch = 'a'; ch <= 'z'; ch++) {
            if (ch == save) continue;
            curr[i] = (char) ch;
            String str = new String(curr);
            if (str.equals(endWord)) return minDistance + 1;

            if (words.contains(str) && !visited.contains(str)) {
              q.add(str);
              visited.add(str);
            }
          }
          curr[i] = save;
        }
        n--;
      }
      minDistance++;
    }
    return 0;
  }
}

public class _127_Word_Ladder {

  public static void main(String[] args) {
    System.out.println(
      new Solution().ladderLength("hot", "dog", List.of("hot", "dog"))
    );
  }
}
