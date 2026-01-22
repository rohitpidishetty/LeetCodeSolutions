import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<String> subdomainVisits(String[] cpdomains) {
    List<String> buffer = new ArrayList<>();
    Map<String, Integer> freq = new HashMap<>();
    for (String cpdom : cpdomains) {
      String[] tokens = cpdom.split(" ");
      int rep = Integer.valueOf(tokens[0]);
      String doms[] = tokens[1].split("[.]");
      int i = doms.length - 1;
      StringBuilder sb = new StringBuilder();
      while (i >= 0) {
        sb.insert(0, doms[i] + (i == doms.length - 1 ? "" : "."));
        String key = sb.toString();
        freq.put(key, freq.getOrDefault(key, 0) + rep);
        i--;
      }
    }
    for (Map.Entry<String, Integer> m : freq.entrySet()) {
      buffer.add(m.getValue() + " " + m.getKey());
    }
    return buffer;
  }
}

public class _811_Subdomain_Visit_Count {

  public static void main(String[] args) {
    System.out.println(
      new Solution().subdomainVisits(
        new String[] {
          "900 google.mail.com",
          "50 yahoo.com",
          "1 intel.mail.com",
          "5 wiki.org",
        }
      )
    );
  }
}
