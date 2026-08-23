import java.util.ArrayList;
import java.util.List;

class Solution {
  private void ipAddr(List<String> ipBucket, String s, List<String> ips) {
    if (s.isEmpty() || ipBucket.size() > 4) {
      if (ipBucket.size() == 4)
        ips.add(new StringBuilder()
            .append(ipBucket.get(0))
            .append(".")
            .append(ipBucket.get(1))
            .append(".")
            .append(ipBucket.get(2))
            .append(".")
            .append(ipBucket.get(3))
            .toString());
      return;
    }
    ipBucket.add(s.substring(0, 1));
    ipAddr(ipBucket, s.substring(1), ips);
    ipBucket.removeLast();
    if (s.length() > 1) {
      String n = s.substring(0, 2);
      if (!n.startsWith("0") && Integer.parseInt(n) <= 255) {
        ipBucket.add(s.substring(0, 2));
        ipAddr(ipBucket, s.substring(2), ips);
        ipBucket.removeLast();
      }
    }
    if (s.length() > 2) {
      String n = s.substring(0, 3);
      if (!n.startsWith("0") && Integer.parseInt(n) <= 255) {
        ipBucket.add(s.substring(0, 3));
        ipAddr(ipBucket, s.substring(3), ips);
        ipBucket.removeLast();
      }
    }
  }

  public List<String> restoreIpAddresses(String s) {
    List<String> ips = new ArrayList<>();
    ipAddr(new ArrayList<>(), s, ips);
    return ips;
  }
}

public class _93_Restore_IP_Address {
  public static void main(String[] args) {
    System.out.println(new Solution().restoreIpAddresses("101023"));
  }
}
