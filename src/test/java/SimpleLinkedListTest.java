import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

    @Test
    void addFirstElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirstElement(1);
        assertEquals("[1]", list.toString());
        list.addFirstElement(2);
        assertEquals("[2, 1]", list.toString());
    }

    @Test
    void addLastElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addLastElement(1);
        assertEquals("[1]", list.toString());
        list.addLastElement(2);
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void addElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addLastElement(1);
        list.addLastElement(2);
        list.addElement(1, 0);
        assertEquals("[1, 0, 2]", list.toString());
    }

    @Test
    void addAll() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }

    @Test
    void get() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirstElement(1);
        assertEquals(1, list.get(0));
        list.addLastElement(2);
        list.addLastElement(3);
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void removeFirstElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.removeFirstElement();
        assertEquals("[2, 3, 4, 5]", list.toString());
    }

    @Test
    void removeLastElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.removeLastElement();
        assertEquals("[1, 2, 3, 4]", list.toString());
    }

    @Test
    void removeElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        list.removeElement(2);
        assertEquals("[1, 2, 4, 5]", list.toString());
    }

    @Test
    void testToString() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirstElement(1);
        assertEquals("[1]", list.toString());
    }

    @Test
    void getSize() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertEquals(0, list.getSize());
        list.addAll(Arrays.asList(1,2,3));
        assertEquals(3, list.getSize());
    }
}