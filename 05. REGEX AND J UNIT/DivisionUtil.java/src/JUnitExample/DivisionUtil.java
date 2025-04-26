package JUnitExample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DivisionUtil {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

public class DivisionTest {

    @Test
    void testValidDivision() {
        assertEquals(5, DivisionUtil.divide(10, 2));
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> DivisionUtil.divide(10, 0));
    }
}
