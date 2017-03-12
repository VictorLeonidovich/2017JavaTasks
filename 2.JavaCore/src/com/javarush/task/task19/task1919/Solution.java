package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        String[] symbols;
        String line;
        Double currentValue;

        while ((line = rd.readLine()) != null) {

            symbols = line.split(" ");

            if (map.containsKey(symbols[0]))
            {
                currentValue = map.get(symbols[0]);
                map.put(symbols[0], Double.parseDouble(symbols[1]) + currentValue);
            } else {
                map.put(symbols[0], Double.parseDouble(symbols[1]));
            }
        }

        rd.close();
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception{
        Map<String, Double> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        String[] lineSplit;
        while ((line = reader.readLine()) != null){
            lineSplit = line.split(" ");
            if (!map.containsKey(lineSplit[0])){map.put(lineSplit[0], 0.0);}
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if (line.contains(entry.getKey())){
                    map.put(lineSplit[0], Double.parseDouble(lineSplit[1].trim()) + entry.getValue());
                }
            }
        }
        reader.close();
        *//*for (Map.Entry<String, Double> entry : map.entrySet()){
                System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }*//*
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}*/
