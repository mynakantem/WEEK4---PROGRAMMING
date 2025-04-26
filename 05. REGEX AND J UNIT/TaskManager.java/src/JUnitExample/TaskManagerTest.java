package JUnitExample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class TaskManagerTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        TaskManager manager = new TaskManager();
        String result = manager.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
