package RegexExample;

import java.util.regex.*;

public class CapitalizedWordsExtractor {

    private static final String CAPITALIZED_WORDS_PATTERN = "\\b[A-Z][a-zA-Z]*\\b";

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile(CAPITALIZED_WORDS_PATTERN);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        System.out.println("Extracted capitalized words:");
        extractCapitalizedWords(text);
    }
}
