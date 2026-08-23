import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

class Solution {
  private Map<Integer, List<Character>> options;
  private Map<String, Integer> map;
  private List<String> wordList;
  private int level;
  private boolean ewp = false;
  private String endWord;

  private void solve(String beginWord, String endWord, int start) {
    if (map.containsKey(beginWord))
      return;
    if (endWord.equals(beginWord))
      ewp = !ewp;
    if ((wordList.contains(beginWord) && !endWord.equals(beginWord)) || start == 0)
      map.put(beginWord, start);
    if (start >= level)
      return;
    char[] tokens = beginWord.toCharArray();
    for (int i = start; i < level; i++) {
      List<Character> ops = options.get(i);
      for (int j = 0; j < ops.size(); j++) {
        char temp = tokens[i];
        tokens[i] = ops.get(j);
        solve(new String(tokens), endWord, start + 1);
        tokens[i] = temp;
      }
    }
  }

  private void solve(List<List<String>> bucket, int magnitude, int start, List<String> bucket_ret,
      List<List<String>> bucket2) {
    if (start >= magnitude) {
      List<String> ret = new ArrayList<>(bucket_ret);
      ret.add(endWord);
      bucket2.add(ret);
      return;
    }
    List<String> explore = bucket.get(start);

    for (int i = 0; i < explore.size(); i++) {
      bucket_ret.add(explore.get(i));
      solve(bucket, magnitude, start + 1, bucket_ret, bucket2);
      bucket_ret.removeLast();
    }
  }

  private List<List<String>> constructPath(Map<String, Integer> map) {
    List<List<String>> bucket = new ArrayList<>();
    BiConsumer<String, Integer> fn = (k, v) -> {
      if (bucket.size() <= v)
        while (bucket.size() <= v)
          bucket.add(new ArrayList<>());
      bucket.get(v).add(k);
    };
    map.forEach(fn);
    List<String> bucket_ret = new ArrayList<>();
    List<List<String>> bucket2 = new ArrayList<>();
    solve(bucket, bucket.size(), 0, bucket_ret, bucket2);
    return new ArrayList<>(Arrays.asList(bucket2.get(0), bucket2.get(bucket2.size() - 1)));
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    options = new HashMap<>();
    map = new HashMap<>();
    this.wordList = wordList;
    int word_len = beginWord.length();
    this.level = word_len;
    this.endWord = endWord;
    int bag_len = wordList.size();
    int j = 0;
    for (int i = 0; i < bag_len; i++) {
      j = 0;
      char[] tokens = wordList.get(i).toCharArray();
      while (j < word_len) {
        if (options.get(j) == null)
          options.put(j, new ArrayList<>());
        if (!options.get(j).contains(tokens[j]) && beginWord.charAt(j) != tokens[j])
          options.get(j).add(tokens[j]);
        j++;
      }
    }
    solve(beginWord, endWord, 0);
    if (!ewp)
      return new ArrayList<>();
    return constructPath(map);
  }
}

public class _126_Word_Ladder_II {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .findLadders("hit", "cog",
            new ArrayList<>(Arrays
                .asList("hot", "dot", "dog", "lot", "log", "cog"))));
  }
}
