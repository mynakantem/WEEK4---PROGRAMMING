package RegexExample;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String[] inputs = {
            "My SSN is 123-45-6789.",
            "Invalid format like 123456789 or 12-345-6789."
        };

        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");

        for (String input : inputs) {
            Matcher matcher = pattern.matcher(input);
            boolean found = false;

            while (matcher.find()) {
                System.out.println("✅ \"" + matcher.group() + "\" is valid");
                found = true;
            }

            if (!found) {
                System.out.println("❌ No valid SSN found in: \"" + input + "\"");
            }
        }
    }
}
