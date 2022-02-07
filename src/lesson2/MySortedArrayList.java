package lesson2;

public class MySortedArrayList <T extends Comparable<T>> extends MyArrayList<T>{
    // Сортированная вставка
    @Override
    public void add(T item) {
        if(item == null){
            return;
        }
        int i = 0;
        while (i< size() && item.compareTo(get(i)) >= 0 ){
            i++;
        }super.add(i,item);
    }

    @Override
    public void add(int index, T item) {
        add(index, item);
    }

    // бинарный поиск
    public int binaryFind(T item){
        int low = 0;
        int high = size() - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(item.compareTo(get(mid))<0){
                high = mid - 1;
            } else if(item.compareTo(get(mid))>0){
                low = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
