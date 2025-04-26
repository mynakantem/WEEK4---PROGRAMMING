package JUnitExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
        System.out.println("Connected to database");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from database");
    }

    public boolean isConnected() {
        return connected;
    }
}

public class DatabaseConnectionTest {
    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected after setup.");
    }

    @Test
    void testConnectionAfterDisconnect() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected.");
    }
}
