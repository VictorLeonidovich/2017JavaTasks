package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
*/

    public class Solution {
        public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args)throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String line;
        String[] lineSplit;
        String word;
        int count = 0;
        while ((line = reader1.readLine()) != null) {
            lineSplit = line.split(" ");
            for (int i = 0; i < words.size(); i++) {
                word = new String(words.get(i).getBytes(), "UTF8");
                //System.out.println(word);
                for (int j = 0; j < lineSplit.length; j++) {
                    //System.out.println(lineSplit[j] + "=========" + word);
                    if (word.equals(lineSplit[j])){
                        count++;
                        //System.out.println(count);
                        continue;
                    }
                }
            }
            if (count == 2){
                System.out.println(line);
            }
            count = 0;
        }


            reader1.close();

    }
}
