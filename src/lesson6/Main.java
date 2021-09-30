package lesson6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int countTree = 10000;
        int balCount = 0;

        for (int i = 0; i < countTree; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            int x = 0;
            while (map.height() < 6) {
                // От -100 до 100
                x = random.nextInt(201) - 100;
                map.put(x, x);
            }
            map.remove(x);
            if (map.isBalance()) {
                balCount++;
            }
        }
        System.out.println("balCount = " + balCount + " countTree = " + countTree);
        System.out.println("balanced " + (double) balCount / countTree * 100 + " %");
        System.out.println("no balanced " + (double) (countTree - balCount) / countTree * 100 + " %");
    }
}
