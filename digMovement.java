public class digMovement {
  public static void main(String[] args) {
    int i = 0;
    int j_start = 0;
    int j = 0;
    int limit = 3;
    for (; i < limit; i++, j++) {

      System.out.println(i + " " + (j + 1));
      if (i == 0 && (j + 1) == limit)
        break;
      if ((j + 1) == limit) {
        i = -1;
        j_start++;
        j = j_start - 1;
      }
    }
  }
}
