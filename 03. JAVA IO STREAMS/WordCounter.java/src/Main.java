import java.io.*;
import java.util.*;

class WordCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
