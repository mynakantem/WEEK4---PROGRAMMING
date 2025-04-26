package RegexExample;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractors {
    public static void main(String[] args) {
      
        String text = "The price is $45.99, and the discount is 10.50.";

        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher matcher = pattern.matcher(text);

        List<String> currencies = new ArrayList<>();

        while (matcher.find()) {
            currencies.add(matcher.group());
        }

        System.out.println(String.join(", ", currencies));
    }
}

