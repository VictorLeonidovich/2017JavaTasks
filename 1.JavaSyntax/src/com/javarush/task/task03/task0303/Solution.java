package com.javarush.task.task03.task0303;

/* 
Обмен валют
Реализуй метод convertEurToUsd, переводящий евро в доллары по заданному курсу.
Вызови его дважды в методе main с любыми параметрами.
Результаты выведи на экран, каждый раз с новой строки.

Подсказка:
Расчет выполняется по формуле: долларСША = евро * курс
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(5, 0.8));
        System.out.println(convertEurToUsd(6, 0.7));
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        return (double)eur * course;
    }
}
