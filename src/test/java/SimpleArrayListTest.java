import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    @Test
    void getSize() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        assertEquals(0, nums.getSize());
        nums.addAll(Arrays.asList(1, 2, 3));
        assertEquals(3, nums.getSize());
        nums.addAll(Arrays.asList(4, 5));
        assertEquals(5, nums.getSize());
    }

    @Test
    void append() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        nums.append(1);
        assertArrayEquals(new Integer[]{1}, nums.toArray());
        nums.append(2);
        assertArrayEquals(new Integer[]{1, 2}, nums.toArray());
    }

    @Test
    void addAll() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        nums.addAll(Arrays.asList(1, 2, 3));
        assertArrayEquals(new Integer[]{1, 2, 3}, nums.toArray() );
    }

    @Test
    void get() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        nums.append(1);
        assertEquals(1, nums.get(0));
    }

    @Test
    void remove() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        nums.addAll(Arrays.asList(1, 2, 3));
        assertEquals(2, nums.remove(1));
        assertArrayEquals(new Integer[]{1, 3}, nums.toArray() );
    }

    @Test
    void testToString() {
        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        nums.addAll(Arrays.asList(1, 2, 3));
        assertEquals("[1, 2, 3]", nums.toString());
    }
}