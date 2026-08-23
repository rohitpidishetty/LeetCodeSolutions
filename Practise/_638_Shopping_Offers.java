// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Solution {

//   private int PRICE;
//    33/65 (Testcases passed)
//   private void solve(
//     List<Integer> price,
//     List<Integer> needs,
//     List<List<Integer>> special,
//     int minPrice
//   ) {
//     for (List<Integer> offer : special) {
//       int n = needs.size();
//       boolean applicable = true;
//       for (int i = 0; i < n; i++) if (offer.get(i) > needs.get(i)) applicable =
//         false;
//       if (applicable) {
//         List<Integer> newNeeds = new ArrayList<>();
//         minPrice = offer.get(n);
//         for (int i = 0; i < n; i++) newNeeds.add(needs.get(i) - offer.get(i));
//         solve(price, newNeeds, special, minPrice);
//       } else {
//         int mandatoryPrice = 0;
//         for (int i = 0; i < n; i++) mandatoryPrice +=
//           needs.get(i) * price.get(i);
//         this.PRICE = Math.min(this.PRICE, minPrice + mandatoryPrice);
//         return;
//       }
//     }
//   }

//   public int shoppingOffers(
//     List<Integer> price,
//     List<List<Integer>> special,
//     List<Integer> needs
//   ) {
//     int n = needs.size();
//     for (int i = 0; i < n; i++) this.PRICE += needs.get(i) * price.get(i);
//     solve(price, needs, special, 0);
//     return this.PRICE;
//   }
// }

// public class _638_Shopping_Offers {

//   public static void main(String[] args) {
//     System.out.println(
//       new Solution()
//         .shoppingOffers(
//           Arrays.asList(2, 3, 4),
//           Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
//           Arrays.asList(1, 2, 1)
//         )
//     );
//   }
// }
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  private Map<String, Integer> memo;

  private int solve(
    List<Integer> price,
    List<Integer> needs,
    List<List<Integer>> special
  ) {
    String key = needs.toString();
    if (this.memo.containsKey(key)) return this.memo.get(key);
    int COST = 0;
    int n = needs.size();
    for (int i = 0; i < n; i++) COST += needs.get(i) * price.get(i);

    for (List<Integer> offer : special) {
      boolean applicable = true;
      List<Integer> newNeeds = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (offer.get(i) > needs.get(i)) {
          applicable = false;
          break;
        }
        newNeeds.add(needs.get(i) - offer.get(i));
      }
      if (!applicable) continue;

      COST = Math.min(COST, offer.get(n) + solve(price, newNeeds, special));
    }

    this.memo.put(key, COST);
    return COST;
  }

  public int shoppingOffers(
    List<Integer> price,
    List<List<Integer>> special,
    List<Integer> needs
  ) {
    this.memo = new HashMap<>();
    return solve(price, needs, special);
  }
}

public class _638_Shopping_Offers {

  public static void main(String[] args) {
    System.out.println(
      new Solution()
        .shoppingOffers(
          Arrays.asList(2, 3, 4),
          Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
          Arrays.asList(1, 2, 1)
        )
    );
  }
}
