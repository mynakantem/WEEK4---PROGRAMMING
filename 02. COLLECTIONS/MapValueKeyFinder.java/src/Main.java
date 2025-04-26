import java.util.*;

    class MaxValueKeyFinder {
        public static String findKeyWithMaxValue(Map<String, Integer> map) {
            String maxKey = null;
            int maxValue = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            return maxKey;
        }

        public static void main(String[] args) {
            Map<String, Integer> input = new HashMap<>();
            input.put("A", 10);
            input.put("B", 20);
            input.put("C", 15);

            String maxKey = findKeyWithMaxValue(input);
            System.out.println("Key with highest value: " + maxKey);  // Output: B
        }
    }























