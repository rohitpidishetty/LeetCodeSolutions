class Solution {

  public String toHex(int num) {
    if (num == 0) return "0";
    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      int shifted = num & 0b1111;
      switch (shifted) {
        case 10:
          sb.append('a');
          break;
        case 11:
          sb.append('b');
          break;
        case 12:
          sb.append('c');
          break;
        case 13:
          sb.append('d');
          break;
        case 14:
          sb.append('e');
          break;
        case 15:
          sb.append('f');
          break;
        default:
          sb.append(shifted);
          break;
      }
      num >>>= 4;
    }
    return sb.reverse().toString();
  }
}

public class _405_Convert_a_Number_to_Hexadecimal {

  public static void main(String[] args) {
    System.out.println(new Solution().toHex(-1));
  }
}
