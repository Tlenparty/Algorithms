package lesson3;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;


    //0 1 2 3 4   E - конец очереди
    // B          B - начало очереди
    //        E   При добавлении Е на шаг впереди. При Е = 5, Е уходит на 0 индекс
    //  4 6 2     При удалении B на шаг впереди

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length; // когда будет E = 5, то она перейдет на 0 (см. остаток отделения)
    }

    // возвращает первый элемент, который вошел
    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue isEmpty");
        }
        return list[begin];
    }

    public void insert(T item) {
        if (isFull()) {
            //Расширение массива***
            throw new RuntimeException("Queue isFull");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

}
