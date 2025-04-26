package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("S1x"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("secure123"));
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("SecurePwd"));
    }
}

