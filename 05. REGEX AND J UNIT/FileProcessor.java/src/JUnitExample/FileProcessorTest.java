package JUnitExample;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    private final FileProcessor processor = new FileProcessor();
    private final String testFile = "testFile.txt";

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, File!";
        processor.writeToFile(testFile, content);

        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Some content");
        File file = new File(testFile);
        assertTrue(file.exists());
    }

    @Test
    void testReadFromNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nonexistent.txt");
        });
    }

    @AfterEach
    void cleanUp() {
        new File(testFile).delete(); // Cleanup after tests
    }
}
