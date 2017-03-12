package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
Реализуй метод sumDigitsInNumber(int number).
Метод на вход принимает целое трехзначное число.
Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.

Пример:
Метод sumDigitsInNumber вызывается с параметром 546.

Пример вывода:
15
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int sotni = number / 100;
        int desyatki = (number - sotni * 100) / 10;
        int edinitsi = (number - sotni * 100) - (desyatki * 10);

        return sotni + desyatki + edinitsi ;
    }
}