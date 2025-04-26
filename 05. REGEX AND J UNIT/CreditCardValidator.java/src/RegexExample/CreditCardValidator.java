package RegexExample;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();

        String visaRegex = "^4\\d{15}$";

        String masterRegex = "^5\\d{15}$";

        if (Pattern.matches(visaRegex, cardNumber)) {
            System.out.println("✅ Valid Visa card");
        } else if (Pattern.matches(masterRegex, cardNumber)) {
            System.out.println("✅ Valid MasterCard");
        } else {
            System.out.println("❌ Invalid card number");
        }

        scanner.close();
    }
}
