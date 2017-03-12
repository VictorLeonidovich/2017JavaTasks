package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        String[] lineSplit;
        //int count = 0;
        Date date = null;
        Integer parseLine;
        String name = "";
        while ((line = reader.readLine()) != null){
            lineSplit = line.split(" ");
            for (int i = 0; i < lineSplit.length; i++) {
                try {
                    parseLine = Integer.parseInt(lineSplit[i]);
                    //count++;
                    date = new GregorianCalendar(Integer.parseInt(lineSplit[lineSplit.length - 1]), Integer.parseInt(lineSplit[lineSplit.length - 2]) - 1, Integer.parseInt(lineSplit[lineSplit.length - 3])).getTime();
                    break;
                }catch (NumberFormatException e){
                    name = name + lineSplit[i] + " ";
                }
            }
            //count = 0;
            PEOPLE.add(new Person(name.trim(), date));
            name = "";
        }
        reader.close();
        //System.out.println(PEOPLE.toString());

    }
}
