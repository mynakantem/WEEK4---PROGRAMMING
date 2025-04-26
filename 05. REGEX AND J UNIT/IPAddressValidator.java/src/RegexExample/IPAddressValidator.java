package RegexExample;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
   
        String ip = "192.168.1.1";

        String ipPattern = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";

        if (ip.matches(ipPattern)) {
        
            String[] parts = ip.split("\\.");
            
            boolean isValid = true;
            for (String part : parts) {
                int value = Integer.parseInt(part);
                if (value < 0 || value > 255) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(ip + " is a valid IPv4 address.");
            } else {
                System.out.println(ip + " is an invalid IPv4 address.");
            }
        } else {
            System.out.println(ip + " is an invalid IPv4 address.");
        }
    }
}

