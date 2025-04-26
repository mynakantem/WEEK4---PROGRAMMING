package RegexExample;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class LinksExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        Pattern pattern = Pattern.compile("\\bhttps?://[\\w.-]+(?:\\.[a-z]{2,})(?:/\\S*)?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        System.out.println(String.join(", ", links));
    }
}
