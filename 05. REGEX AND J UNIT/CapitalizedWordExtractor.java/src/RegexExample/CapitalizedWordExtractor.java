package RegexExample;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        List<String> capitalizedWords = new ArrayList<>();

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        System.out.println("Capitalized Words:");
        System.out.println(String.join(", ", capitalizedWords));
    }
}

