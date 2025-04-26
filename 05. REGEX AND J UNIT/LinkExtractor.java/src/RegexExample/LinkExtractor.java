package RegexExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        String regex = "\\bhttps?://[^\\s]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        System.out.println(String.join(", ", links));
    }
}
