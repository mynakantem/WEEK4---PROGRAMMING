package RegexExample;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "PHP");


        StringBuilder result = new StringBuilder();
        
        for (String lang : languages) {

            Pattern pattern = Pattern.compile("\\b" + lang + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(lang);
            }
        }

        System.out.println(result.toString());
    }
}
