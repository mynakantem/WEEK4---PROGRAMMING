package RegexExample;

import java.util.regex.Pattern;
import java.util.Scanner;

public class IPAdressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address to validate: ");
        String ip = scanner.nextLine();

        String ipv4Pattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                           + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        boolean isValid = Pattern.matches(ipv4Pattern, ip);

        if (isValid) {
            System.out.println("✅ Valid IPv4 address");
        } else {
            System.out.println("❌ Invalid IPv4 address");
        }

        scanner.close();
    }
}
