import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FrequencyCounter {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> inputList = List.of("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = countFrequency(inputList);
        System.out.println(frequencyMap);
    }
}
