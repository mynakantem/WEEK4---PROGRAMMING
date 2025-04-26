import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SubsetChecker {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean result = isSubset(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of set2? " + result);
    }
}