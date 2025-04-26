package RegexExample;

import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatedWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1).toLowerCase());
        }

        System.out.println(String.join(", ", repeatedWords));
    }
}
