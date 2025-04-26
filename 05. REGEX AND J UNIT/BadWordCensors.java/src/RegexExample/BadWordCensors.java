package RegexExample;

import java.util.regex.Pattern;

public class BadWordCensors {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        for (String badWord : badWords) {
            String regex = "(?i)\\b" + Pattern.quote(badWord) + "\\b";
            text = text.replaceAll(regex, "****");
        }

        System.out.println(text);
    }
}
