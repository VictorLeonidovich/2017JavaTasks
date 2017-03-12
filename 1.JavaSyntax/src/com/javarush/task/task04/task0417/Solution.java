package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
Ввести с клавиатуры три целых числа.
Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

Пример для чисел 1 2 2:
2 2

Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();
        if (a == b && a == c && c == b){
            System.out.println(a + " " + b + " " + c);
        }else if (a == b){
            System.out.println(a + " " + b);
        }else if (a == c){
            System.out.println(a + " " + c);
        }else if (c == b){
            System.out.println(b + " " + c);
        }


    }
}