package lesson4;

public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public void insert(T item) {
        list.insertLast(item);
    }

    public T remove() {
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
