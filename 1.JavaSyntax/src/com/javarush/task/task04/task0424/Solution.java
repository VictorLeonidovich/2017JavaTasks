package com.javarush.task.task04.task0424;

/* 
Три числа
Ввод с клавиатуры, сравнение чисел и вывод на экран —
у студентов 4 уровня секретного центра JavaRush эти навыки оттачиваются до автоматизма.
Давайте напишем программу, в которой пользователь вводит три числа с клавиатуры.
Затем происходит сравнение, и если мы находим число, которое отличается от двух других,
выводим на экран его порядковый номер.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();
        /*list.add(a);
        list.add(b);
        list.add(c);*/
        if (c != b && a != c && a != b){

        }else if (a != b && a != c){
            System.out.println(1);
        }else if (b != a && b != c){
            System.out.println(2);
        }else if (c != b && a != c){
            System.out.println(3);
        }

    }
}
