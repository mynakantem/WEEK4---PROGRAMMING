package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    UserRegistration ur = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> ur.registerUser("johnDoe", "john@example.com", "pass1234"));
    }

    @Test
    void testInvalidUsername() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> 
            ur.registerUser("abc", "john@example.com", "pass1234"));
        assertTrue(e.getMessage().contains("Invalid username"));
    }

    @Test
    void testInvalidEmail() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> 
            ur.registerUser("johnDoe", "johnexample.com", "pass1234"));
        assertTrue(e.getMessage().contains("Invalid email"));
    }

    @Test
    void testInvalidPassword() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> 
            ur.registerUser("johnDoe", "john@example.com", "password"));
        assertTrue(e.getMessage().contains("Password"));
    }
}
