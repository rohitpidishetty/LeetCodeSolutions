import java.util.ArrayList;
import java.util.List;

public class _43 {

  public String product(String x1, String x2) {
    int len_1 = x1.length();
    int len_2 = x2.length();
    String a = new String();
    String b = new String();
    if (len_1 > len_2) {
      a = x1;
      b = x2;
    } else {
      b = x1;
      a = x2;
    }
    int n = a.length() - 1;
    int m = b.length() - 1;
    int x = 0;
    List<String> numbers = new ArrayList<>();
    for (int j = m; j >= 0; j--) {
      int carryForward = 0;
      StringBuilder res = new StringBuilder();
      res.repeat('0', x++);
      for (int placevalue = n; placevalue >= 0; placevalue--) {
        int product =
          (a.charAt(placevalue) - '0') * (b.charAt(j) - '0') + carryForward;
        int considerable = product % 10;
        carryForward = product / 10;
        res.append(considerable);
      }
      res.append(carryForward);
      numbers.add(res.reverse().toString());
    }
    int maxLenght = 0;
    int nums = 0;
    for (String number : numbers) {
      maxLenght = Math.max(maxLenght, number.length());
      nums++;
    }
    for (int i = 0; i < nums; i++) {
      int len = numbers.get(i).length();
      if (len < maxLenght) {
        numbers.set(
          i,
          new StringBuilder(numbers.get(i))
            .reverse()
            .repeat("0", maxLenght - len)
            .reverse()
            .toString()
        );
      }
    }
    StringBuilder answer = new StringBuilder();
    int carryForward = 0;
    for (int pv = maxLenght - 1; pv >= 0; pv--) {
      int res = 0;
      for (String number : numbers) res += number.charAt(pv) - '0';
      res += carryForward;
      answer.append(res % 10);
      carryForward = res / 10;
    }
    answer.append(carryForward);
    answer.reverse();
    int skip = 0;
    maxLenght = answer.length();
    while (answer.charAt(skip) == '0' && skip < maxLenght - 1) skip++;
    return answer.substring(skip, maxLenght);
  }

  public static void main(String[] args) {
    System.out.println(new _43().product("2", "3"));
  }
}
