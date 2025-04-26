package JUnitExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ListManager {

    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}

// ------- JUnit 5 Test Cases -------
class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        ListManager.removeElement(list, 20);
        assertFalse(list.contains(20));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 1);
        ListManager.addElement(list, 2);
        assertEquals(2, ListManager.getSize(list));

        ListManager.removeElement(list, 1);
        assertEquals(1, ListManager.getSize(list));
    }
}

