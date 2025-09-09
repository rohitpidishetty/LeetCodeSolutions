import java.util.*;

public class Amazon_OA_Q2 {

  public static String findMissingData(String firstInfo, String secondInfo) {
    int n = firstInfo.length();
    TreeMap<Character, Integer> counter = new TreeMap<>();
    for (char c : firstInfo.toCharArray()) {
      counter.put(c, counter.getOrDefault(c, 0) + 1);
    }

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < n; i++) {
      boolean found = false;
      for (char c : counter.keySet()) {
        if (counter.get(c) == 0) continue;
        result.append(c);
        counter.put(c, counter.get(c) - 1);
        StringBuilder suffix = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
          System.out.println(entry);
          for (int j = 0; j < entry.getValue(); j++) {
            suffix.append(entry.getKey());
          }
        }

        String candidate = result.toString() + suffix.toString();

        if (candidate.compareTo(secondInfo) > 0) {
          found = true;

          break;
        }

        // Backtrack
        result.deleteCharAt(result.length() - 1);
        counter.put(c, counter.get(c) + 1);
      }
      System.out.println(result);

      if (!found) return "-1";
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(findMissingData("aad", "aac"));
  }
}
