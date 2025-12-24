public class ZigZag_Snippet {
  public static void main(String[] args) {
    int n = 4;
    for (int i = 0; i < n; i++) {
      int k = 0;
      for (int j = i; j < n; j++, k++) {
        System.out.println("[" + k + ", " + j + "]");
      }
    }
  }
}

/**
  * [0, 0]
  * [1, 1]
  * [2, 2]
  * [3, 3]
  * [0, 1]
  * [1, 2]
  * [2, 3]
  * [0, 2]
  * [1, 3]
  * [0, 3]
 */