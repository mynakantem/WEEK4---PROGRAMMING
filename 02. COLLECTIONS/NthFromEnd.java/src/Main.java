import  java.util.LinkedList;
import java.util.ListIterator;

class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if(n <= 0) throw new IllegalArgumentException("N must be greater than 0");

        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        for(int i = 0; i<n; i++) {
            if(!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the size of the list");
            }
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);
        System.out.println("The " + N + "-th element from the end of is: " + result);
    }
}