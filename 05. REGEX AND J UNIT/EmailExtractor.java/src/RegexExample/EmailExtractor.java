package RegexExample;

import java.util.regex.*;

public class EmailExtractor {
  
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        System.out.println("Extracted email addresses:");
        extractEmails(text);
    }
}
