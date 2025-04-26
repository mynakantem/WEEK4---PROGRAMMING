package RegexExample;
import java.util.regex.*;

public class HexColourValidator {
    public static void main(String[] args) {
        String[] colors = {
            "#FFA500",   // valid
            "#ff4500",   // valid
            "#123",      // invalid
            "#GGGGGG",   // invalid - not hex
            "#ABCDEF",   // valid
            "#abc1234"   // invalid - too long
        };

        Pattern pattern = Pattern.compile("^#[0-9a-fA-F]{6}$");

        for (String color : colors) {
            if (pattern.matcher(color).matches()) {
                System.out.println("✅ \"" + color + "\" → Valid");
            } else {
                System.out.println("❌ \"" + color + "\" → Invalid");
            }
        }
    }
}
