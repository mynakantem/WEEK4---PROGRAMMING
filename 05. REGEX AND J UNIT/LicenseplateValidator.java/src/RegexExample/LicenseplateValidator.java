package RegexExample;

import java.util.Scanner;

public class LicenseplateValidator {

    private static final String LICENSE_PATTERN = "^[A-Z]{2}\\d{4}$";

    public static boolean isValidPlate(String plate) {
        return plate.matches(LICENSE_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String input = scanner.nextLine();

        if (isValidPlate(input)) {
            System.out.println("✅ Valid license plate!");
        } else {
            System.out.println("❌ Invalid license plate!");
        }

        scanner.close();
    }
}
