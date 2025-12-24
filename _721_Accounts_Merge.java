import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  private int find(int[] uf, int x) {
    if (uf[x] == x) return x;
    return uf[x] = find(uf, uf[x]);
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    int[] union_find = new int[n];
    for (int i = 0; i < n; i++) union_find[i] = i;
    System.out.println(Arrays.toString(union_find));
    Map<String, Integer> map = new HashMap<>();
    int recordNumber = 0;
    for (List<String> accs : accounts) {
      int i = 0;
      for (String acc : accs) {
        if (i != 0) {
          if (map.containsKey(acc)) {
            int firstRecNum = map.get(acc);
            int x = find(union_find, firstRecNum), y = find(
              union_find,
              recordNumber
            );
            union_find[y] = x;
          } else map.put(acc, recordNumber);
        }
        i++;
      }
      recordNumber++;
    }
    Map<Integer, List<Integer>> groups = new HashMap<>();
    for (int i = 0; i < union_find.length; i++) {
      int eleOf = find(union_find, i);
      groups.computeIfAbsent(eleOf, k -> new ArrayList<>()).add(i);
    }

    List<List<String>> res = new ArrayList<>();

    for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
      int root = entry.getKey();
      List<Integer> records = entry.getValue();

      Set<String> emails = new HashSet<>();
      for (int idx : records) {
        for (int j = 1; j < accounts.get(idx).size(); j++) {
          emails.add(accounts.get(idx).get(j));
        }
      }

      List<String> merged = new ArrayList<>();
      merged.add(accounts.get(root).get(0));
      List<String> emailList = new ArrayList<>(emails);
      Collections.sort(emailList);

      merged.addAll(emailList);
      res.add(merged);
    }
    return res;
  }
}

public class _721_Accounts_Merge {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .accountsMerge(
          Arrays.asList(
            new ArrayList<>(
              Arrays.asList(
                "John",
                "johnsmith@mail.com",
                "john_newyork@mail.com"
              )
            ),
            new ArrayList<>(
              Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")
            ),
            new ArrayList<>(Arrays.asList("Mary", "mary@gmail.com")),
            new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"))
          )
        )
    );
  }
}
