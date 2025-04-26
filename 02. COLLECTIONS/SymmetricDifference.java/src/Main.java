import java.util.HashSet;
import java.util.Set;

class SymmetricDifference {
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);

        union.addAll(set2);
        intersection.retainAll(set2);

        union.removeAll(intersection);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = getSymmetricDifference(set1, set2);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
