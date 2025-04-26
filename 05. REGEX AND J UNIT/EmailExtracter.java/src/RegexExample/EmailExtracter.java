package RegexExample;

import java.util.regex.*;
import java.util.*;

public class EmailExtracter {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Email Addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
