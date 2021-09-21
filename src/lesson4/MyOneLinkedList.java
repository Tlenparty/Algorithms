package lesson4;

public class MyOneLinkedList<T> {
    // Внутренний класс для перезаписывания связей внутри списка
    private class Node {
        T value; // значение
        Node next; // ссылка на следующий элемент

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;  // ссылка на первый элемент
    private int size;  // сколько элементов есть

    public void insertFirst (T item){
        Node newNode = new Node(item, first);
        first = newNode;
        size++;
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.next;
        size--;
        return temp;
    }

    public final T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return first.value;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(item, current.next);
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
        while (current.next != null && !current.next.value.equals(item)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next= current.next.next;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
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
