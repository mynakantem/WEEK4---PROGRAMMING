package JUnitExample;

public class TaskManager {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}
