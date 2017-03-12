package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        StringBuffer stringBuffer = new StringBuffer();
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        String[] lineSplit;
        while ((line = reader.readLine()) != null){
            lineSplit = line.split(" ");
            for (int i = 0; i < lineSplit.length; i++) {
                if (lineSplit[i].matches(".*[0-9].*")){stringBuffer.append(lineSplit[i] + " ");}
            }
        }
        writer.write(stringBuffer.toString());
        writer.close();
        reader.close();

    }
}
