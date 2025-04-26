import java.io.*;

class ImageByteArrayConversion {
    public static void main(String[] args) {
        String originalImagePath = "originalImage.jpg";
        String newImagePath = "copiedImage.jpg";

        try (
                FileInputStream fis = new FileInputStream(originalImagePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(newImagePath)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image copied successfully as " + newImagePath);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
