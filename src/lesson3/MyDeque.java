package lesson3;

import java.util.EmptyStackException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //L 0 1 2 3 4  R
    //  B
    //      E ->    При insertLeft() вставляем элемент и E двигаем
    //  ? 4 6 ?     При removeLeft() E двигаем назад и извлекаем элемент

    //L 0 1 2 3 4  R
    //  B
    //      E     При insertRight() B двигаем назад и добавляем
    //  4 6       При removeRight() просто удаляем элемент со стороны B

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    public int previousIndex(int index) {
        return (list.length + index - 1) % list.length;
    }

    public void insertLeft(T item) {
        if (isFull()) {
            //Расширение массива***
            throw new RuntimeException("Queue isFull");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;
    }

    public T removeRight() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        end = previousIndex(end);
        list[end] = null;
        return temp;
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }
        return list[begin];
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[previousIndex(end)];
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = begin; i != end; i = nextIndex(i)) {
            sb.append(list[i]).append(", ");
        }
        if (sb.length() == 0) {
            sb.append("[]");
        } else {
            sb.insert(0, "[");
            sb.setLength(sb.length() - 2);
            sb.append("]");
        }
        return sb.toString();
    }

    public int length(){
        return list.length;
    }
}
