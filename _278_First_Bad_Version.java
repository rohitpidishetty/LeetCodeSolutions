/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int initialVersion = 1;
    int finalVersion = n;
    int firstCrackVersion = n;
    while (initialVersion <= finalVersion) {
      int midVersion = initialVersion + (finalVersion - initialVersion) / 2;
      if (!isBadVersion(midVersion))
        initialVersion = midVersion + 1;
      else {
        firstCrackVersion = midVersion;
        finalVersion = midVersion - 1;
      }
    }
    return firstCrackVersion;

  }
}
