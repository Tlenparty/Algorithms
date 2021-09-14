import lesson2.MyArrayList;

public class Main {

    public static void main(String[] args) {
        int n = 100000;
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>(n);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>(n);
        MyArrayList<Integer> myArrayList3 = new MyArrayList<>(n);

        for (int i = 0; i < n; i++) {
            myArrayList1.add((int) (Math.random() * n));
        }

        for (int i = 0; i < n; i++) {
            myArrayList2.add((int) (Math.random() * n));
        }

        for (int i = 0; i < n; i++) {
            myArrayList3.add((int) (Math.random() * n));
        }

        System.out.println("Начальный массив1" + myArrayList1);
        System.out.println("Начальный массив2" + myArrayList2);
        System.out.println("Начальный массив3" + myArrayList3);

        long start1 = System.currentTimeMillis();
        myArrayList1.bubbleSortOptimized();
        long finish1 = System.currentTimeMillis();
        long elapsed1 = finish1 - start1;
        System.out.println("Массив1 отсортирован:" + myArrayList1);
        System.out.println("Время сортировки1:" + elapsed1);

        long start2 = System.currentTimeMillis();
        myArrayList2.selectionSort();
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Массив2 отсортирован:" + myArrayList2);
        System.out.println("Время сортировки2:" + elapsed2);

        long start3 = System.currentTimeMillis();
        myArrayList3.insertionSort();
        long finish3 = System.currentTimeMillis();
        long elapsed3 = finish3 - start3;
        System.out.println("Массив3 отсортирован:" + myArrayList3);
        System.out.println("Время сортировки3:" + elapsed3);
    }

}
