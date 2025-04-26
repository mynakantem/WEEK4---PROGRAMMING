import java.util.ArrayList;
import java.util.List;

class RotateList {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0) return list;

        positions = positions % size;

        List<T> rotatedList = new ArrayList<>();

        rotatedList.addAll(list.subList(positions, size));

        rotatedList.addAll(list.subList(0, positions));

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        List<Integer> rotatedList = rotateList(list, 2);

        System.out.println(rotatedList);
    }
}
