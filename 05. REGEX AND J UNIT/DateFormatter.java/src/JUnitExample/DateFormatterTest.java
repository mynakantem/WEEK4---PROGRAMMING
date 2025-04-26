package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;

public class DateFormatterTest {

    @Test
    void testValidDate() throws ParseException {
        assertEquals("04-05-2025", DateFormatter.formatDate("2025-05-04"));
        assertEquals("15-08-2024", DateFormatter.formatDate("2024-08-15"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("04/05/2025"); // Wrong format
        });
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(ParseException.class, () -> {
            DateFormatter.formatDate("2024-02-30"); // Invalid day
        });
    }
}
