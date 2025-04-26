package JUnitExample;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.length() < 5) {
            throw new IllegalArgumentException("Invalid username: must be at least 5 characters.");
        }
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || password.length() < 8 || !password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters and contain a digit.");
        }
        // Assume user is registered if all checks pass
    }
}
