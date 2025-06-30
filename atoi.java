public class atoi {

  private int atoi_convert(String n) {
    char[] tokens = n.toCharArray();
    boolean digit = false;
    boolean sign = false;
    int res = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tokens.length; i++) {
      int ascii = tokens[i];
      if (tokens[i] == ' ' && !sign && !digit) {
        continue;
      } else if ((tokens[i] == '-' || tokens[i] == '+') && !sign && !digit) {
        sb.append(tokens[i]);
        res = res * 10 + ((int) tokens[i] - 48);
        sign = true;
      } else if ((ascii >= 48 && ascii <= 57)) {
        digit = true;
        sb.append(tokens[i]);
        res = res * 10 + ((int) tokens[i] - 48);
      } else
        break;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(new atoi().atoi_convert("-042"));
  }
}
