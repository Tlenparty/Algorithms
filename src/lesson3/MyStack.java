package lesson3;

import java.util.EmptyStackException;

public class MyStack <T>{
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    // добавление элемента в конце стэка
    public void push(T item) {
        if (isFull()) {
            int newCapacity = (int) (size * 1.5) + 1;
            reCapacity(newCapacity);
            throw new StackOverflowError();
        }
        list[size] = item;
        size++;
    }

    // удаление элемента из стека
    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void reCapacity(int newSize){
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }
}
