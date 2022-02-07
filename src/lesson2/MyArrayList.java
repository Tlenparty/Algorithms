package lesson2;

import java.util.Arrays;

public class MyArrayList<T extends Comparable> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        checkSize();
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkSize();
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        }
        // идем с обратной стороны
        for (int i = size; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    private int index(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(T item) {
        return index(item);
    }

    public void remove(int index) {
        // checkIndex()
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public void remove(T item) {
        int i = index(item);
        remove(i);
    }

    private void checkSize() {
        if (size > list.length) {
            int newCapacity = (int) (size * 1.5) + 1;
            T[] temp = (T[]) new Object[newCapacity];
            System.arraycopy(list,0,temp,0,size);
            list = temp;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        checkSize();
        return list[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    // сортировка выбором
    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                {
                    if (less(list[j], list[iMin]))
                        iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    // сортировка вставками
    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    // пузырьковая сортировка
    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    // пузырьковая сортировка оптимизированная)
    public void bubbleSortOptimized() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public void addRandomElements(int countValue){
        for (int i = 0; i < countValue; i++) {

        }
    }


}
