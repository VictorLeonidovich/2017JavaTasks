package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder
3. Список result должен быть заполнен корректными парами согласно условию задачи.
4. В классе Solution должен содержаться вложенный класс Pair.
5. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        //Scanner scanner = new Scanner(new File(reader.readLine()));

String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = reader1.readLine()) != null){
            stringBuilder.append(line).append(" ");
        }

        reader1.close();
        reader.close();
        //System.out.println(stringBuilder.toString());
        String[] splittedLine = stringBuilder.toString().trim().split(" ");

        for (int i = 0; i < splittedLine.length - 1; i++) {

            for (int j = i + 1; j < splittedLine.length; j++) {

                String splittedLineReverse = new StringBuilder(splittedLine[j]).reverse().toString();
                //System.out.println(splittedLine[i] + "    --    " + splittedLineReverse);
                if (splittedLine[i].equals(splittedLineReverse)) {
                    Pair pair = new Pair();
                    pair.first = splittedLine[i];
                    pair.second = splittedLine[j];
                    int count = 0;
                    for (Pair rez : result){
                        if (pair.equals(rez)){count = 1;}
                    }
                    if (count == 0){result.add(pair);}
                    //System.out.println("add: " + pair);
                }
            }

        }
        for (Pair rez : result){
            System.out.println(rez.first + " " + rez.second);
        }



    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
