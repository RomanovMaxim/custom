import java.util.Arrays;
import java.util.Collection;

public class SimpleArrayList<E> {

    private int capacity;
    private int size;
    private Object[] data;

    public SimpleArrayList(int initialCapacity) {
        this.capacity = initialCapacity;
        data = new Object[capacity];
        size = 0;
    }

    public SimpleArrayList() {
        this(3);
    }

    public int getSize() {
        return size;
    }

    public void append(E element) {
        if (size == capacity) {
            grow(capacity * 2);
        }
        data[size] = element;
        size++;
    }

    public void addAll(Collection <E> c) {
        Object[] a = c.toArray();
        if (a.length == 0) {
            return;
        }

        int newSize = size + a.length;
        if (capacity < newSize) {
            grow(newSize);
        }

        System.arraycopy(a, 0, data, size, a.length);
        size = newSize;
    }

    private void grow(int minCapacity) {
        Object[] bufData =new Object[capacity];
        System.arraycopy(data, 0, bufData, 0, size);
        capacity = minCapacity;
        data = new Object[capacity];
        System.arraycopy(bufData, 0, data, 0, size);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of range [0, " + (size-1) + "].");
        }
        return (E) data[index];
    }

    public E remove(int index) {
        E value = get(index);
        System.arraycopy(data, index+1, data, index, size - index - 1);
        data[size - 1] = null;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        return (E[]) Arrays.copyOf(data, size);
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[').append(data[0]);
        for (int i = 1; i < size; i++) {
            b.append(", ").append(data[i]);
        }
        return b.append(']').toString();
    }
}
