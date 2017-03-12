package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        String[] lineSplit;
        int count = 0;
        while ((line = reader.readLine()) != null){
            lineSplit = line.split(" ");
            for (int i = 0; i < lineSplit.length; i++) {
                if (lineSplit[i].length() > 6){
                    if (count == 0){

                        writer.write((lineSplit[i]));
                        count = 1;
                    }else {
                        writer.write("," + lineSplit[i]);
                    }
                }

            }
        }


        writer.close();
        reader.close();

    }
}
