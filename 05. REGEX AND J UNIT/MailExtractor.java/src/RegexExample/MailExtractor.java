package RegexExample;

import java.util.regex.*;
import java.util.*;

public class MailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        List<String> emails = new ArrayList<>();

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        for (String email : emails) {
            System.out.println(email);
        }
    }
}
