package com.javarush.task.task04.task0428;

/* 
Положительное число
Ввести с клавиатуры три целых числа.
 Вывести на экран количество положительных чисел в исходном наборе.

Пример для чисел -4 6 6:
2

Пример для чисел -6 -6 -3:
0
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
        int count = 0;
        if (a > 0){
            count++;
        }
        if (b > 0){
            count++;
        }
        if (c > 0){
            count++;
        }
        System.out.println(count);

    }
}
