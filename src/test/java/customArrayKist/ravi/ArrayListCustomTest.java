package customArrayKist.ravi;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListCustomTest {
    static ArrayListCustom<Object> testIObjects;
    @BeforeAll
    static void initial() {
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

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
    }

    @org.junit.jupiter.api.Test
    void addAll() {
    }

    @org.junit.jupiter.api.Test
    void testAddAll() {
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void set() {
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
    }

    @org.junit.jupiter.api.Test
    void subList() {
    }

    @org.junit.jupiter.api.Test
    void display() {
    }
}