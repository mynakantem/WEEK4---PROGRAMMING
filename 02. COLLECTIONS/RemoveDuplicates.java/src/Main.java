import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> inputList) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : inputList) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> output = removeDuplicates(input);

        System.out.println(output);
    }
}
