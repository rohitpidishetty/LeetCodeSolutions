// 52/53 Passed
// class Solution {

//   private boolean starts_with_1_0__(int data) {
//     return (
//       ((data & (1 << 7)) == 0 ? 0 : 1) == 1 &&
//       ((data & (1 << 6)) == 0 ? 0 : 1) == 0
//     );
//   }

//   public boolean validUtf8(int[] data) {
//     int n = data.length;
//     boolean status = true;
//     int j = 0;
//     for (int i = 0; i < n; i++) {
//       int range = byteRange(data[i]);
//       switch (range) {
//         case 1:
//           status &= ((data[i] & (1 << 7)) == 0 ? 0 : 1) == 0;
//           break;
//         case 2:
//         case 3:
//         case 4:
//           if (i + range > n) return false;

//           for (j = i + 1; j <= (i + (range - 1)); j++) {
//             status &= starts_with_1_0__(data[j]);
//             if (j > n) return false;
//           }
//           i = j - 1;
//           break;
//         default:
//           return false;
//       }
//       if (!status) return false;
//     }

//     return status;
//   }

//   private int byteRange(int starting) {
//     if ((((starting & (1 << 7)) == 0) ? 0 : 1) == 0) return 1;
//     int setBit = 0;
//     int value = 0;
//     int set = 7;
//     int maxValue = 128;
//     for (int i = 0; i < 4; i++) {
//       setBit = (1 << (set--));
//       int bit = ((starting & setBit) == 0 ? 0 : 1);
//       if (bit == 0) break;
//       value += maxValue;
//       maxValue /= 2;
//     }
//     if (value >= 192 && value < 224) return 2;
//     else if (value >= 224 && value < 240) return 3;
//     else if (value >= 240 && value < 247) return 4;
//     return Integer.MAX_VALUE;
//   }
// }

// public class _393_UTF_8_Validation {

//   public static void main(String[] args) {
//     System.out.println(new Solution().validUtf8(new int[] { 145 }));
//   }
// }

class Solution {

  private boolean starts_with_1_0__(int data) {
    return (((data & (1 << 7)) != 0) && ((data & (1 << 6)) == 0));
  }

  public boolean validUtf8(int[] data) {
    int n = data.length;
    boolean status = true;
    int j = 0;
    for (int i = 0; i < n; i++) {
      int range = byteRange(data[i]);
      switch (range) {
        case 1:
          status &= ((data[i] & (1 << 7)) == 0);
          break;
        case 2:
        case 3:
        case 4:
          if (i + range > n) return false;
          for (j = i + 1; j <= i + (range - 1); j++) {
            if (!starts_with_1_0__(data[j])) return false;
          }
          i = j - 1;
          break;
        default:
          return false;
      }
      if (!status) return false;
    }

    return status;
  }

  private int byteRange(int starting) {
    if ((starting & (1 << 7)) == 0) return 1;

    int count = 0;
    for (int i = 7; i >= 0; i--) {
      if (((starting >> i) & 1) == 1) count++;
      else break;
    }

    if (count == 1 || count > 4) return Integer.MAX_VALUE;
    return count;
  }
}

public class _393_UTF_8_Validation {

  public static void main(String[] args) {
    System.out.println(
      new Solution().validUtf8(new int[] { 240, 162, 138, 147, 17 })
    );
  }
}
