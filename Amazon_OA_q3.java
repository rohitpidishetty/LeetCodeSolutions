import java.util.Arrays;

public class Amazon_OA_q3 {

  /**
   * The developers at AWS IAM are designing a new checksum logic for an authentication module.
   * The checksum is calculated as an array hash, where hash[i] = secretKey[i] % param[i].
   * There are n parameters for the checksum, where the ith parameter is represented by param[i].
   * The secrete key consists of n values, with the i'th value denoted as secretKey[i].
   * A good secret key is one that results in more distinct values in the hash array.
   * Given the array param n, determine the maximum number of possible distinct values in the has array by selecting an appropriate secretKey.
   * Example:
   * n = 3 param = [1,2,4] You can choose secretKey=[1,3,2] resulting in the hash array [0,1,2] which consists of 3 distinct elements.
   * findHash has the following parameter: int param[n]: the diff parameters needed for the checksum logic.
   * Returns, int: the manximum number of distinct elements possible in hash.
   */
  public static void main(String[] args) {
    int n = 3;
    int param[] = { 1000000000, 1000000000, 1000000000 };
    Arrays.sort(param);
    int max = param[n - 1];
    max = Math.min(n, max);
    System.out.println(max);
  }
}
