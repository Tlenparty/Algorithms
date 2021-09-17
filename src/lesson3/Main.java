package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

//*1. Создать класс для реализации дека.
//2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
//3. Прикрутить увеличение массива в классе стек и приоритетная очередь.
//4***. Реализовать метод увеличивающий массив в классе очередь.*/

public class Main {

    public static void main(String[] args) {

        MyDeque<Integer> myDeque = new MyDeque<>(4);
        myDeque.insertLeft(1);
        myDeque.insertLeft(9);
      /*  myDeque.insertRight(3);
        myDeque.insertRight(0);*/

        for (int i = 0; i < myDeque.length(); i++) {
            System.out.print(myDeque.removeLeft());
        }

        // Программа, которая переворачивает строки
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите строку: ");
            var str = reader.readLine();
            MyStack<Character> myStack = new MyStack<>(str.length());
            for (int i = 0; i < str.length(); i++) {
                myStack.push(str.charAt(i));
            }
            System.out.println("Перевернутая строка: ");
            for (int i = 0; i < str.length(); i++) {
                System.out.print(myStack.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
