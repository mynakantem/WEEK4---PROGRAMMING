package RegexExample;

import java.util.Scanner;

public class HexColorValidator {

    private static final String HEX_COLOR_PATTERN = "^#([A-Fa-f0-9]{6})$";

    public static boolean isValidHexColor(String code) {
        return code.matches(HEX_COLOR_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String input = scanner.nextLine();

        if (isValidHexColor(input)) {
            System.out.println("✅ Valid hex color code!");
        } else {
            System.out.println("❌ Invalid hex color code!");
        }

        scanner.close();
    }
}
