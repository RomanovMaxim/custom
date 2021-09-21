import java.util.Arrays;
import java.util.Collection;

public class SimpleLinkedList <E>{

    private int size;

    private Node<E> first;
    private Node<E> last;

    public SimpleLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] a = (E[]) new Object[size];
        for(int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        return (E[]) Arrays.copyOf(a, size);
    }

    public int getSize() {
        return size;
    }

    public void addFirstElement(E element) {
        Node<E> linkFirst = first;
        Node<E> newElement = new Node<>(null, element, linkFirst);
        first = newElement;
        if (linkFirst == null) {
            last = newElement;
        } else {
            linkFirst.prev = newElement;
        }
        size++;
    }

    public void addLastElement(E element) {
        Node<E> linkLast = last;
        Node<E> newElement = new Node<>(linkLast, element, null);
        last = newElement;
        if (linkLast == null) {
            first = newElement;
        } else {
            linkLast.next = newElement;
        }
        size++;

    }

    public void addElement(int index, E element) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of range [0, " + size + "].");
        }
        if (index == 0) {
            addFirstElement(element);
        } else if (index == size) {
            addLastElement(element);
        } else {
            Node<E> prevElement = first;
            for(int i = 0; i < index - 1; i++) {
                prevElement = prevElement.next;
            }
            Node<E> nextElement = prevElement.next;
            Node<E> newElement = new Node<>(prevElement, element, nextElement);
            prevElement.next = newElement;
            nextElement.prev = newElement;
            size++;
        }
    }

    public void addAll(Collection<E> c) {
        if (c.size() == 0) {
            return;
        }
        for (E element: c) {
            addLastElement(element);
        }
    }

    public E get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of range [0, " + size + "].");
        }
        if (index == 0) {
            return (E) first.item;
        }
        if (index == size - 1) {
            return (E) last.item;
        }
        Node<E> currentElement = first;
        for(int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return (E) currentElement.item;
    }

    @SuppressWarnings("unchecked")
    public E removeFirstElement() {
        if (size == 0) {
            return null;
        }
        Node<E> element = first;
        first = first.next;
        first.prev = null;
        element.next = null;
        size--;
        return (E) element;
    }

    @SuppressWarnings("unchecked")
    public E removeLastElement() {
        if (size == 0) {
            return null;
        }
        Node<E> element = last;
        last = last.prev;
        last.next = null;
        element.prev = null;
        size--;
        return (E) element;
    }

    @SuppressWarnings("unchecked")
    public E removeElement(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of range [0, " + (size-1) + "].");
        }
        if (index == 0) {
            return removeFirstElement();
        }
        if (index == size - 1) {
            return removeLastElement();
        }
        Node<E> currentElement = first;
        for(int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        Node<E> prevElement = currentElement.prev;
        Node<E> nextElement = currentElement.next;
        prevElement.next = nextElement;
        nextElement.prev = prevElement;
        currentElement.next = null;
        currentElement.prev = null;
        size--;
        return (E) currentElement;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        Node<E> currentElement = first;
        StringBuilder b = new StringBuilder();
        b.append('[').append(currentElement.item);
        for (int i = 1; i < size; i++) {
            currentElement = currentElement.next;
            b.append(", ").append(currentElement.item);
        }
        return b.append(']').toString();
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item,  Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }


}
