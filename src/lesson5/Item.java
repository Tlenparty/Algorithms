package lesson5;

public class Item {
    private final String name; //название вещи
    private final int weight; //вес
    private final int value; //стоимость

    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight(){
        return value/(double)weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{w:" + weight + ",v:" + value + "}";
    }
}