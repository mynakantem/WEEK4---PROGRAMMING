package RegexExample;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String[] inputs = {
            "My SSN is 123-45-6789.",
            "Invalid one is 123456789."
        };

        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");

        for (String input : inputs) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("✅ \"" + matcher.group() + "\" is valid");
            } else {
                System.out.println("❌ No valid SSN found in: \"" + input + "\"");
            }
        }
    }
}
