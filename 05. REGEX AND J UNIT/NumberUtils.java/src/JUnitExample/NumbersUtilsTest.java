package JUnitExample;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number), number + " should be odd");
    }
}
