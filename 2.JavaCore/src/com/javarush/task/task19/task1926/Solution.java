package com.javarush.task.task19.task1926;

/* 
Перевертыши
1 Считать с консоли имя файла. Считать содержимое файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке.
2.2 вывести на экран.
3 Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader1.readLine()) != null){
            line = new StringBuilder(line).reverse().toString() + System.lineSeparator();
            stringBuffer.append(line);
        }
        System.out.println(stringBuffer.toString());
        reader1.close();


    }
}
