package lesson6;

import java.util.Random;

public class Main {

    /**
     * 1.Создать и запустить программу для построения двоичного дерева.
     * В цикле построить двадцать деревьев с глубиной в 6 уровней.
     * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
     * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
     * 2.Проанализировать, какой процент созданных деревьев являются несбалансированными.
     */
    public static void main(String[] args) {
        //MyTreeMap<Integer, String> map = new MyTreeMap<>();
        final int min = -100; // Минимальное число для диапазона
        final int max = 100; // Максимальное число для диапазона
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            MyTreeMap<Integer, String> map = new MyTreeMap<>();
            while(map.height()!=7){
                map.put((random.nextInt(max - min)) + min,"i");
            }
            System.out.println(map);
            i++;
        }
    }
}
