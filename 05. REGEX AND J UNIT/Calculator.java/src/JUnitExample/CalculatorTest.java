package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

 Calculator calc = new Calculator();

 @Test
 void testAdd() {
     assertEquals(10, calc.add(6, 4));
 }

 @Test
 void testSubtract() {
     assertEquals(2, calc.subtract(6, 4));
 }

 @Test
 void testMultiply() {
     assertEquals(24, calc.multiply(6, 4));
 }

 @Test
 void testDivide() {
     assertEquals(2, calc.divide(8, 4));
 }

 @Test
 void testDivideByZero() {
     Exception exception = assertThrows(ArithmeticException.class, () -> {
         calc.divide(10, 0);
     });
     assertEquals("Division by zero is not allowed.", exception.getMessage());
 }
}

