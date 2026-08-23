import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int line = maxWidth;
    List<String> ret = new ArrayList<>();
    List<String> payload = new ArrayList<>();
    List<List<String>> data = new ArrayList<>();
    String word = new String();

    for (int i = 0; i < words.length; i++) {
      word = words[i];
      line -= (word.length() + 1);
      if (line >= 0)
        payload.add(word);
      else {
        data.add(new ArrayList<>(payload));
        line = maxWidth;
        payload.clear();
        --i;
      }
      if (i == words.length - 1) {
        data.add(new ArrayList<>(payload));
        payload.clear();
      }
    }
    for (List<String> arr : data)
      ret.add(this.justify(arr, maxWidth));

    return ret;
  }

  private String justify(List<String> line, int maxWidth) {
    // System.out.println(line);
    int len = 0;
    int empty = 0;
    for (String word : line)
      len += word.length();
    empty = line.size() - 1;
    // System.out.println(empty);
    int spaces = maxWidth - len;
    // System.out.println(spaces);
    String finalString = new String();
    if (empty > 0) {

      int spaces_inbtw = spaces / empty;
      int extra = spaces % empty;

      int i = 0;
      for (i = 0; i < line.size() - 1; i++) {
        finalString += (line.get(i) + spaces(spaces_inbtw) + extra(extra));
        extra = 0;
      }
      finalString += line.get(i);

    } else {
      finalString += line.get(0) + spaces(maxWidth - line.get(0).length());
    }
    return finalString;
  }

  private String spaces(int c) {
    if (c == 0)
      return "";
    int i = 0;
    String ret = "";
    while (i < c) {
      ret += " ";
      i++;
    }
    return ret;
  }

  private String extra(int c) {
    if (c == 0)
      return "";
    int i = 0;
    String ret = "";
    while (i < c) {
      ret += " ";
      i++;
    }
    return ret;
  }
}

public class TextJustification {
  public static void main(String[] args) {
    System.out.println(new Solution().fullJustify(new String[] {
        "This",
        "is",
        "an",
        "example",
        "of",
        "text",
        "justification."
    }, 16));
  }
}
