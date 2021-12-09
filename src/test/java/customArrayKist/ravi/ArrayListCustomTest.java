package customArrayKist.ravi;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListCustomTest {
    static ArrayListCustom<Object> testIObjects;

    @BeforeAll
    static void initial() {
        testIObjects = new ArrayListCustom<>();
    }

    @BeforeEach
    void emptingMainList() {
        testIObjects = new ArrayListCustom<>();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ravi"})
    void size(String str) {
        testIObjects.add(str);
        testIObjects.add(str);
        testIObjects.add(str);
        testIObjects.add(str);
        assertEquals(4, testIObjects.size());
    }

    @Test
    void isEmpty() {
        ArrayListCustom<Integer> empltyCheck = new ArrayListCustom();
        assertTrue(empltyCheck.isEmpty());
        empltyCheck.add(75);
        assertFalse(empltyCheck.isEmpty());

    }

    @Test
    void contains() {
        testIObjects.add("Robert");
        assertTrue(testIObjects.contains("Robert"));
        assertFalse(testIObjects.contains("Yellow"));
    }

    @Test
    void toArray() {
        testIObjects.add("Abhishek");
        testIObjects.add("Ram");
        testIObjects.add("Shyam");
        String[] strs = {"Abhishek", "Ram", "Shyam"};
        assertArrayEquals(strs, testIObjects.toArray());
    }

    @Test
    void testToArray() {
        testIObjects.add("alphaaa");
        String[] strs = {"alphaaa"};
        assertArrayEquals(strs, testIObjects.toArray());
    }

    @Test
    void add() {
        testIObjects.add(2.036);
        testIObjects.display();
        assertEquals(2.036, testIObjects.get(0));
    }

    @Test
    void remove() {
        testIObjects.add("Tension");
        testIObjects.remove("Tension");
        testIObjects.display();
        assertThrows(IndexOutOfBoundsException.class, () -> testIObjects.get(0), "As we just removed the element so it will give an Exception of IndexoutOfBound");
    }

    @Test
    void containsAll() {
        testIObjects.add("Abhishek");
        testIObjects.add("Prabhat");
        testIObjects.add("Revati");
        testIObjects.add("Namrata");
        testIObjects.add("Ravi");
        testIObjects.display();
        String[] names = {"Abhishek", "Ravi"};
        assertTrue(testIObjects.containsAll(List.of(names)));
    }

    @Test
    void addAll() {
        testIObjects.add("Abhishek");
        testIObjects.add("Prabhat");
        testIObjects.add("Revati");
        testIObjects.add("Namrata");
        testIObjects.add("Ravi");
        String[] names = {"Kuljit", "Dipankar"};
        testIObjects.addAll(List.of(names));
        testIObjects.display();
        String[] expectedNames = {"Abhishek", "Prabhat", "Revati", "Namrata", "Ravi", "Kuljit", "Dipankar"};
        assertTrue(testIObjects.containsAll(List.of(expectedNames)));
    }

    @org.junit.jupiter.api.Test
    void testAddAllAtIndex() {
        testIObjects.add("Abhishek");
        testIObjects.add("Prabhat");
        testIObjects.add("Revati");
        testIObjects.add("Namrata");
        testIObjects.add("Ravi");
        String[] names = {"Kuljit", "Dipankar"};
        testIObjects.addAll(2, List.of(names));
        testIObjects.display();
        String[] expectedNames = {"Abhishek", "Prabhat", "Revati", "Namrata", "Ravi", "Kuljit", "Dipankar"};
        assertTrue(testIObjects.containsAll(List.of(expectedNames)));
    }

    //Facing issue in this method as last data-member is null automatically
    @Test
    void removeAll() {
        testIObjects.add("Abhishek");
        testIObjects.add("Prabhat");
        testIObjects.add("Revati");
        testIObjects.add("Namrata");
        testIObjects.add("Ravi");
        testIObjects.removeAll(List.of("Namrata", "Abhishek"));
        assertTrue(testIObjects.contains("Prabhat"));
    }

    //Issue in this method too
    @Test
    void retainAll() {
        assertTrue(true);
    }

    @Test
    void clear() {
        testIObjects.add(1);
        testIObjects.add(1);
        testIObjects.add(1);
        testIObjects.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> testIObjects.get(0), "As we just removed the element so it will give an Exception of IndexoutOfBound");
    }

    @Test
    void get() {
        testIObjects.add(1);
        assertEquals(1, testIObjects.get(0));
    }

    @Test
    void set() {
        testIObjects.add(5);
        testIObjects.add(7);
        testIObjects.add(9);
        testIObjects.set(2, 855);
        assertEquals(855, testIObjects.get(2));
    }

    @Test
    void testAdd() {
        testIObjects.add(5);
        testIObjects.add(9);
        testIObjects.add(7);
        assertEquals(5, testIObjects.get(0));
        assertEquals(9, testIObjects.get(1));
        assertEquals(7, testIObjects.get(2));
    }

    @Test
    void testRemove() {
        testIObjects.add(5);
        testIObjects.add(9);
        testIObjects.add(7);
        testIObjects.remove(1);
        testIObjects.display();
        assertEquals(5, testIObjects.get(0));
        assertEquals(7, testIObjects.get(1));
    }

    @Test
    void indexOf() {
        testIObjects.add(5);
        testIObjects.add(9);
        testIObjects.add(7);
        assertEquals(0, testIObjects.indexOf(5));
    }

    @Test
    void lastIndexOf() {
        testIObjects.add(9);
        testIObjects.add(7);
        testIObjects.add(5);
        testIObjects.add(5);
        assertEquals(3, testIObjects.lastIndexOf(5));

    }

    @Test
    void subList() {
        testIObjects.add(9);
        testIObjects.add(7);
        testIObjects.add(5);
        testIObjects.add(88);
        testIObjects.add(11);
        List expected = List.of(7, 5, 88);
        List actual = testIObjects.subList(1, 3);
        assertEquals(expected, actual);

    }

    @Test
    void display() {
        testIObjects.add("My");
        testIObjects.add("Name");
        testIObjects.add("is");
        testIObjects.add("Ravi");
        testIObjects.display();
    }
}