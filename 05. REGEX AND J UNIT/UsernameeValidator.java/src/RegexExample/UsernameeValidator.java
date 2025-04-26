package RegexExample;

import java.util.regex.*;

public class UsernameeValidator {
    public static void main(String[] args) {
        String[] usernames = {
            "user_123",    // valid
            "123user",     // invalid (starts with number)
            "us",          // invalid (too short)
            "user@name",   // invalid (special character)
            "Username_15", // valid
            "A2345"        // valid
        };

        Pattern pattern = Pattern.compile("^[a-zA-Z][\\w]{4,14}$");

        for (String username : usernames) {
            if (pattern.matcher(username).matches()) {
                System.out.println("✅ \"" + username + "\" → Valid");
            } else {
                System.out.println("❌ \"" + username + "\" → Invalid");
            }
        }
    }
}

