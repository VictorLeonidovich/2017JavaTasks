package com.javarush.task.task04.task0427;

/* 
Описываем числа
Ввести с клавиатуры целое число в диапазоне 1 — 999. Вывести его строку-описание следующего вида:
«четное однозначное число» — если число четное и имеет одну цифру,
«нечетное однозначное число» — если число нечетное и имеет одну цифру,
«четное двузначное число» — если число четное и имеет две цифры,
«нечетное двузначное число» — если число нечетное и имеет две цифры,
«четное трехзначное число» — если число четное и имеет три цифры,
«нечетное трехзначное число» — если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 — 999, в таком случае ничего не выводить на экран.

Пример для числа 100:
четное трехзначное число

Пример для числа 51:
нечетное двузначное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        reader.close();
        int b = (a + "").length();
        if (a > 0 && a < 1000){
            if (b == 1){
                if (a % 2 == 0){
                    System.out.println("четное однозначное число");
                } else if (a % 2 != 0){
                    System.out.println("нечетное однозначное число");
                }
            }else if (b == 2){
                if (a % 2 == 0){
                    System.out.println("четное двузначное число");
                } else {
                    System.out.println("нечетное двузначное число");
                }
            }else if (b == 3){
                if (a % 2 == 0){
                    System.out.println("четное трехзначное число");
                } else if (a % 2 != 0){
                    System.out.println("нечетное трехзначное число");
                }
            }
        }


    }
}
