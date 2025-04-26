package filecopy;
import java.io.*;

class FileCopyComparison {

    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) {
        String sourceFile = "\"C:\\Users\\mynak\\Desktop\\java projects\\week6\\day5\\FileCopyProject.java\\src\\filecopy\\FileCopyComparision.java\""; 
        String bufferedDest = "C:\\Users\\YourName\\Desktop\\buffered_copy.dat";
        String unbufferedDest = "C:\\Users\\YourName\\Desktop\\unbuffered_copy.dat";

        long startBuffered = System.nanoTime();
        copyWithBufferedStreams(sourceFile, bufferedDest);
        long endBuffered = System.nanoTime();

        long startUnbuffered = System.nanoTime();
        copyWithUnbufferedStreams(sourceFile, unbufferedDest);
        long endUnbuffered = System.nanoTime();

        System.out.println("Buffered Streams Time: " + (endBuffered - startBuffered) / 1_000_000.0 + " ms");
        System.out.println("Unbuffered Streams Time: " + (endUnbuffered - startUnbuffered) / 1_000_000.0 + " ms");
    }

    private static void copyWithBufferedStreams(String source, String destination) {
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Buffered copy failed: " + e.getMessage());
        }
    }

    private static void copyWithUnbufferedStreams(String source, String destination) {
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Unbuffered copy failed: " + e.getMessage());
        }
    }
}
