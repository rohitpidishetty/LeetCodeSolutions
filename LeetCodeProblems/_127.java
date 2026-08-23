import java.util.*;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord))
      return 0;

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int level = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();

        if (word.equals(endWord))
          return level;

        char[] wordChars = word.toCharArray();
        for (int j = 0; j < wordChars.length; j++) {
          char originalChar = wordChars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            wordChars[j] = c;
            String newWord = new String(wordChars);
            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
              queue.offer(newWord);
              visited.add(newWord);
            }
          }
          wordChars[j] = originalChar;
        }
      }
      level++;
    }

    return 0;
  }
}

public class _127 {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .ladderLength("hit", "cog",
            new ArrayList<>(Arrays
                .asList("hot", "dot", "dog", "lot", "log", "cog"))));
  }
}
