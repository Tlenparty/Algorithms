package lesson4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.insertFirst(5);
        mll.insertFirst(15);
        mll.insertFirst(25);
        mll.insertFirst(35);

        //System.out.println(mll.removeFirst());
        System.out.println(mll);
        mll.insert(2,111);
        System.out.println(mll);
    }
}
