import java.util.Arrays;

public class ZigZag {

  private String convert(String stream, int nr) {
    if (nr == 1)
      return stream;
    char[] tokens = stream.toCharArray();
    char[][] zzb = new char[nr][tokens.length];
    int i = 0;
    int j = 0;
    int idx = 0;
    while (i < nr && j < tokens.length) {
      if (idx < tokens.length)
        zzb[i][j] = tokens[idx++];
      i++;
      if (i >= nr) {
        --i;
        while (i > 0) {
          --i;
          ++j;
          if (idx < tokens.length)
            zzb[i][j] = tokens[idx++];
        }
        i++;
      }
    }
    String finalString = new String();
    for (i = 0; i < zzb.length; i++) {
      for (j = 0; j < zzb[i].length; j++) {
        if (zzb[i][j] != '\0')
          finalString += zzb[i][j];
      }
    }
    return finalString;
  }

  public static void main(String[] args) {
    System.out.println(new ZigZag().convert("A", 1));
  }
}
