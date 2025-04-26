package JUnitExample;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtils {

 public static String reverse(String str) {
     return new StringBuilder(str).reverse().toString();
 }

 public static boolean isPalindrome(String str) {
     return str.equals(reverse(str));
 }

 public static String toUpperCase(String str) {
     return str.toUpperCase();
 }
}

public class StringUtilsTest {

 @Test
 void testReverse() {
     assertEquals("tac", StringUtils.reverse("cat"));
     assertEquals("madam", StringUtils.reverse("madam"));
 }

 @Test
 void testIsPalindrome() {
     assertTrue(StringUtils.isPalindrome("madam"));
     assertTrue(StringUtils.isPalindrome("racecar"));
     assertFalse(StringUtils.isPalindrome("hello"));
 }

 @Test
 void testToUpperCase() {
     assertEquals("HELLO", StringUtils.toUpperCase("hello"));
     assertEquals("JAVA", StringUtils.toUpperCase("Java"));
 }
}
