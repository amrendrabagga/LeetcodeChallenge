package june.week3;

import java.util.regex.Pattern;

public class Day2_ValidateIpv4AndIpv6 {
    public String validIPAddress(String IP) {
        String ipv4Regex = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|25[0-5]|2[0-4][0-9])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|25[0-5]|2[0-4][0-9])$";
        String ipv6Regex = "^((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]{1,4})$";

        Pattern ipv4Pattern = Pattern.compile(ipv4Regex);
        Pattern ipv6Pattern = Pattern.compile(ipv6Regex);

        if (ipv4Pattern.matcher(IP).matches()) {
            return "IPv4";
        }
        else if (ipv6Pattern.matcher(IP).matches()) {
            return "IPv6";
        }
        else {
            return "Neither";
        }
    }
}
