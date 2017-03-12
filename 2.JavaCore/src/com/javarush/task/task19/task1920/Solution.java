package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        String[] lineSplit = new String[0];

        while ((line = reader.readLine()) != null){
            lineSplit = line.split(" ");
            if (!map.containsKey(lineSplit[0])){map.put(lineSplit[0], 0.0);}

            for (Map.Entry<String, Double> entry : map.entrySet()){

                if (line.contains(entry.getKey())){
                    map.put(lineSplit[0], Double.parseDouble(lineSplit[1]) + entry.getValue());
                }
            }
        }

        Double max = 0.000;
        for (Map.Entry<String, Double> entry : map.entrySet()){

            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()){

            if (max <= entry.getValue()) {
                System.out.println(entry.getKey());
            }
            //System.out.println(entry.getKey());
        }
        reader.close();
        //System.out.println(map.toString());
    }
}
