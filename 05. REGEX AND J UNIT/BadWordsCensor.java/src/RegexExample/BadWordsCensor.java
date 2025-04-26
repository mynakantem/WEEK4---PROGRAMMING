package RegexExample;

import java.util.*;

public class BadWordsCensor {
    public static void main(String[] args) {
        
        String text = "This is a damn bad example with some stupid words.";
     
        List<String> badWords = Arrays.asList("damn", "stupid");
        
        for (String badWord : badWords) {
            text = text.replaceAll("\\b" + badWord + "\\b", "****");
        }

        System.out.println(text);
    }
}
