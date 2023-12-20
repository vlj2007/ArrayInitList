package pro.sky.ArrayInitList;

import org.junit.jupiter.api.Test;
import pro.sky.ArrayInitList.exception.InvalidIndexException;
import pro.sky.ArrayInitList.exception.NullItemException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitListImplTest {

    private final ArrayInitListImpl arrayInitListImpl = new ArrayInitListImpl();
    private final ArrayInitListImpl otherArrayInitListImpl = new ArrayInitListImpl();

    Integer expectedInt1 = 1;
    Integer expectedInt2 = 2;

    @Test
    void testToString() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        String expected = "list=[1, 2, null, null, null, null, null, null, null, null]";
        String actual = arrayInitListImpl.toString();
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        assertEquals(expectedInt1, arrayInitListImpl.add(expectedInt1));
    }

    @Test
    void testAdd() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        assertEquals(2, arrayInitListImpl.size());

    }

    @Test
    void set() {
        arrayInitListImpl.add(0, expectedInt1);
        arrayInitListImpl.set(0, expectedInt2);
        assertTrue(arrayInitListImpl.contains(expectedInt2));
        assertFalse(arrayInitListImpl.contains(expectedInt1));
        assertThrows(NullItemException.class, () -> arrayInitListImpl.set(0, (Integer) null));
        assertThrows(InvalidIndexException.class, () -> arrayInitListImpl.set(11, expectedInt1));
    }

    @Test
    void remove() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.remove(expectedInt1);
        assertEquals(expectedInt1, arrayInitListImpl.get(0));
    }

    @Test
    void testRemove() {
        arrayInitListImpl.add(0, expectedInt1);
        arrayInitListImpl.remove(0);
        assertFalse(arrayInitListImpl.contains(expectedInt1));
        assertThrows(InvalidIndexException.class, () -> arrayInitListImpl.remove(2));
    }

    @Test
    void contains() {
        arrayInitListImpl.add(expectedInt1);
        assertTrue(arrayInitListImpl.contains(expectedInt1));
    }

    @Test
    void indexOf() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        assertEquals(0, arrayInitListImpl.indexOf(expectedInt1));
    }

    @Test
    void lastIndexOf() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        assertEquals(0, arrayInitListImpl.indexOf(expectedInt1));
    }

    @Test
    void get() {
        arrayInitListImpl.add(expectedInt1);
        assertTrue(arrayInitListImpl.get(0).equals(expectedInt1));
        assertFalse(arrayInitListImpl.get(0).equals(expectedInt2));
        assertThrows(InvalidIndexException.class, () -> arrayInitListImpl.get(-5));
    }

    @Test
    void testEquals() {
        arrayInitListImpl.add(expectedInt1);
        otherArrayInitListImpl.add(expectedInt1);
        assertTrue(arrayInitListImpl.equals(otherArrayInitListImpl));
    }

    @Test
    void size() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        assertEquals(2, arrayInitListImpl.size());

    }

    @Test
    void isEmpty() {
        assertTrue(arrayInitListImpl.isEmpty());
        arrayInitListImpl.add(expectedInt1);
        assertFalse(arrayInitListImpl.isEmpty());
    }

    @Test
    void clear() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        arrayInitListImpl.clear();
        assertEquals(arrayInitListImpl.size(), 0);
    }

    @Test
    void quickSort() {
        arrayInitListImpl.add(27);
        arrayInitListImpl.add(4);
        arrayInitListImpl.add(113);
        arrayInitListImpl.add(1);
        arrayInitListImpl.quickSort(arrayInitListImpl.toArray(), 0, arrayInitListImpl.toArray().length - 1);
    }

    @Test
    void toArray() {
        arrayInitListImpl.add(expectedInt1);
        arrayInitListImpl.add(expectedInt2);
        Integer[] expectedArray = {1, 2, null, null, null, null, null, null, null, null};
        Integer[] actualArray = {1, 2, null, null, null, null, null, null, null, null};
        assertArrayEquals(expectedArray, actualArray);
    }
}
