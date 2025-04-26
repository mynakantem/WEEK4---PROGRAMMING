import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class WordFrequencyCounter {

    public static void main(String[] args) {
        String filePath = "input.txt";
        HashMap<String, Integer> wordFreq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("Word Frequencies:");
            for (String word : wordFreq.keySet()) {
                System.out.println(word + " = " + wordFreq.get(word));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
