package RegexExample;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        String lowerText = text.toLowerCase();

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(lowerText);

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        while (matcher.find()) {
            String word = matcher.group(1);
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}

