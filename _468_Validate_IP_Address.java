import java.util.Arrays;
import java.util.regex.Pattern;

class Solution {

  public String validIPAddress(String queryIP) {
    if (
      Pattern.matches(
        "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$",
        queryIP
      )
    ) return "IPv4";
    else if (
      Pattern.matches("^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", queryIP)
    ) return "IPv6";
    return "Neither";
  }
}

public class _468_Validate_IP_Address {

  public static void main(String[] args) {
    System.out.println(new Solution().validIPAddress("172.16.254.1"));
  }
}
