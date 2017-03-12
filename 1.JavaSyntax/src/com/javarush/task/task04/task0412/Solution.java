package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
Ввести с клавиатуры число.
Если число положительное, то увеличить его в два раза.
Если число отрицательное, то прибавить единицу.
Если введенное число равно нулю, необходимо вывести ноль.
Вывести результат на экран.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.parseInt(reader.readLine());
        if (integer > 0){
            integer = integer * 2;
        }else if (integer < 0){
            integer = integer + 1;
        }else if (integer == 0){
            integer = 0;
        }
        System.out.println(integer);

    }

}