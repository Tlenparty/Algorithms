package lesson4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {
    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }


    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return current.value;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = getLast();
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return temp;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return first.value;
    }

    public final T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return last.value;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(current, item, current.next);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (getFirst().equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.value.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
        return true;
    }

    public int indexOf(T item) {
        if (isEmpty()) {
            return -1;
        }
        if (getFirst().equals(item)) {
            return 0;
        }
        Node current = first;
        int index = 0;
        while (current != null && !current.value.equals(item)) {
            current = current.next;
            index++;
        }
        if (current == null) {
            return -1;
        } else {
            return index;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(current.value).append(", ");
            current = current.next;
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
