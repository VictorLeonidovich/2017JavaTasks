package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + — *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов — нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();
    public static int add(int d1, int d2){
        return d1 + d2;

    }
    public static int dec(int d1, int d2){
        return d1 - d2;

    }
    public static int mult(int d1, int d2){
        return d1 * d2;

    }
    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String[] res = result.split(" ");

        Integer dig1 = Integer.parseInt(res[0]);
        Integer dig2 = Integer.parseInt(res[2]);
int equation = 0;
        if ("+".equals(res[1]))
        {
            equation = add((int)dig1, (int)dig2);
        }else if ("-".equals(res[1]))
        {
            equation = dec((int) dig1, (int) dig2);
        }else if ("*".equals(res[1]))
        {
            equation = mult((int) dig1, (int)dig2);
        }


        System.out.println(res[0] + " " + res[1] + " " + res[2] + " " + res[3] + " " + equation);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

