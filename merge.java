import java.util.Arrays;

public class merge {
  private static void __merge__(int[] buffer1, int[] buffer2) {

    int r = 0;
    int b = 0;
    int idx = 0;
    int[] finalBuff = new int[buffer1.length + buffer2.length];

    while (r < buffer1.length && b < buffer2.length)
      finalBuff[idx++] = buffer1[r] < buffer2[b] ? buffer1[r++] : buffer2[b++];
    while (r < buffer1.length)
      finalBuff[idx++] = buffer1[r++];
    while (b < buffer2.length)
      finalBuff[idx++] = buffer2[b++];
    System.out.println(Arrays.toString(finalBuff));

  }

  public static void main(String[] args) {
    merge.__merge__(new int[] { 1, 3, 5 }, new int[] { 2, 4, 6, 7, 9 });
  }
}
