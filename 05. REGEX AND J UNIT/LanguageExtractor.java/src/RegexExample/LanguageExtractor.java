package RegexExample;

import java.util.regex.*;
import java.util.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String[] languages = {
            "Python", "Java", "JavaScript", "C\\+\\+", "C#", "Go", "Ruby", "Swift",
            "Kotlin", "PHP", "Perl", "Rust", "Scala", "TypeScript", "R", "Dart",
            "Haskell", "Elixir"
        };

        List<String> foundLanguages = new ArrayList<>();

        for (String lang : languages) {
            Pattern pattern = Pattern.compile("\\b" + lang + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(lang.replace("\\+", "+"));
            }
        }

        System.out.println(String.join(", ", foundLanguages));
    }
}

