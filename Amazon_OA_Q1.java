public class Amazon_OA_Q1 {

  private static int minHours(int d1, int c1, int d2, int c2) {
    int hours = 0;
    while (d1 > 0 || d2 > 0) {
      hours++;
      if (hours % c1 == 0 && hours % c2 == 0) continue;
      else if (hours % c1 == 0 && d2 > 0) {
        // d2 can deliver
        d2--;
      } else if (hours % c2 == 0 && d1 > 0) {
        // d1 can deliver
        d1--;
      } else {
        if (d1 >= d2 && d1 > 0) d1--;
        else if (d2 > 0) d2--;
      }
    }
    return hours;
  }

  public static void main(String[] args) {
    System.out.println(minHours(3, 3, 4, 2));
  }
}
