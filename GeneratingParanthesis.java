import java.util.ArrayList;
import java.util.List;

public class GeneratingParanthesis {

  private void recFn(int n, StringBuilder sb, int opbc, int clbc, List<String> res) {
    if (clbc == n && clbc == opbc) {
      res.add(sb.toString());
      return;
    }
    if (opbc < n) {
      recFn(n, sb.append("("), opbc + 1, clbc, res);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (clbc < opbc) {
      recFn(n, sb.append(")"), opbc, clbc + 1, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private List<String> generate(int n) {
    List<String> res = new ArrayList<>();
    recFn(n, new StringBuilder(), 0, 0, res);
    return res;
  }

  public static void main(String[] args) {
    List<String> res = new ArrayList<>();
    System.out.println(new GeneratingParanthesis().generate(3));
  }
}

// import java.util.ArrayList;
// import java.util.List;

// public class GeneratingParanthesis {

  private void recFn(int n, StringBuilder sb, int opbc, int clbc, List<String> res) {
    System.out.println(sb + " " + opbc + " " + clbc);
    if (clbc == n && clbc == opbc) {
      res.add(sb.toString());
      return;
    }
    if (opbc < n) {
      recFn(n, sb.append("("), opbc + 1, clbc, res);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (clbc < opbc) {
      recFn(n, sb.append(")"), opbc, clbc + 1, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private List<String> generate(int n) {
    List<String> res = new ArrayList<>();
    recFn(n, new StringBuilder(), 0, 0, res);
    return res;
  }

  public static void main(String[] args) {
    List<String> res = new ArrayList<>();
    System.out.println(new GeneratingParanthesis().generate(3));
  }
}