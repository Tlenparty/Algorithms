package lesson5;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    /**
     * 1. Написать программу по возведению числа в степень с помощью рекурсии.
     * a*a*a*a*a = a^n
     * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
     */
        /**
         * 1       2        3        4
         * Ожерелье 400/4ед     0       0         0       400
         * Кольцо 250/1ед      250     250       250      400
         * Подвеска 200/3ед    250     250       250      450
         */
        public static void main(String[] args) {
            // System.out.println(raisingNumberPower(2,5));
            final int W = 4; // грузоподъемность рюкзака
            // массив вещей
            Item[] items = {new Item("Ожерелье", 4, 400),
                    new Item("Кольцо", 1, 250),
                    new Item("Подвеска", 3, 200)
            };
            // Сортировка в обратном порядке по удельной ценности O(N*log(N)
            Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

            System.out.println(Arrays.toString(items));
            int weightSoFar = 0;
            double valueSoFar = 0;
            int currentItem = 0;

            while (currentItem < items.length && weightSoFar != W) {
                if (weightSoFar + items[currentItem].getWeight() < W) {
                    // берем объект целиком
                    valueSoFar += items[currentItem].getValue();
                    weightSoFar += items[currentItem].getWeight();

                } else {
                    // берем часть объекта
                    valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) *
                            items[currentItem].getValue();
                    weightSoFar = W; // полный рюкзак
                }
                currentItem++;
            }
            System.out.println("Ценность наилучшего набора " + valueSoFar);
        }


        public static void reversPrint(char[] arr) {
            reversPrint(arr, arr.length - 1);
        }

        private static void reversPrint(char[] arr, int n) {
            if (n < 0) {
                return;
            }
            System.out.print(arr[n]);
            reversPrint(arr, n - 1);
        }

        public static int recMultiply(int a, int b) {
            if (b == 0) {
                return 0;
            }
            return recMultiply(a, b - 1) + a;
        }

        public static int multiply(int a, int b) {
            int sum = 0;
            for (int i = 0; i < b; i++) {
                sum += a;
            }
            return sum;
        }

        public static int recTriangleNum(int n) {
            if (n == 1) {
                return 1;
            }
            return recTriangleNum(n - 1) + n;
        }

        public static int triangleNum(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }

        public static long recFibo(int n) {
            System.out.print(n + " ");
            if (n < 3) {
                return 1;
            }
            return recFibo(n - 1) + recFibo(n - 2);
        }

        public static long fibo(int n) {
            long a = 1;
            long b = 1;
            for (int i = 3; i <= n; i++) {
                b = b + a;
                a = b - a;
            }
            return b;
        }


        public static int fact(int n) {
            int f = 1;
            for (int i = 2; i <= n; i++) {
                f *= i;
            }
            return f;
        }

        public static int recFact(int n) {
            if (n == 1) {
                return 1;
            }
            return recFact(n - 1) * n;
        }

        public static int raisingNumberPower(int number, int lvl) {
            if (lvl == 1) {
                return number;
            }
            if (lvl == 0) {
                return 1;
            }
            if (lvl > 0) {
                return number * raisingNumberPower(number, lvl - 1);
            } else {
                return -1;
            }
        }
    }
