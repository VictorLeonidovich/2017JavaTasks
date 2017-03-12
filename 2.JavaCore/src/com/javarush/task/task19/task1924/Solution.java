package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();
        String input;
        BufferedReader in = new BufferedReader(new FileReader(file1));
        String bodyOfFile = "";
        ArrayList<String> fileListStrings = new ArrayList<String>();
        while ((input = in.readLine()) != null)
            fileListStrings.add(input);
        in.close();
        for (String strinOfFile : fileListStrings) {
            String[] arrWords = strinOfFile.split(" ");
            for (int i = 0; i < arrWords.length; i++) {

                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    try {
                        if (Integer.parseInt(arrWords[i]) == entry.getKey())
                            arrWords[i] = entry.getValue();
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            for (String currentString : arrWords)
                System.out.print(currentString + " ");
            System.out.println();
        }
    }
}


/*
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static String replace(String word) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                Integer integer = Integer.parseInt(word);
                if (integer.equals(entry.getKey())) {
                    word = entry.getValue();
                }

            } catch (Exception e) {
                continue;
            }

        }

        return word;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();


        StringBuffer text = new StringBuffer();
        String[] lineSplit;
        FileReader fileReader = new FileReader(file);

        BufferedReader reader1 = new BufferedReader(fileReader);
        String line;

        while ((line = reader1.readLine()) != null) {
text.append(line);
            text.append(System.lineSeparator());
        }
        reader.close();
        reader1.close();
        fileReader.close();

            lineSplit = text.toString().split(" ");
        StringBuffer text2 = new StringBuffer();
            for (int i = 0; i < lineSplit.length; i++) {
                lineSplit[i] = Solution.replace(lineSplit[i]);
                text2.append(lineSplit[i] + " ");
            }

    System.out.println(text.toString());

    }
}
*/

/*
while ((line = reader1.readLine()) != null) {

        lineSplit = line.split(" ");
        for (int i = 0; i < lineSplit.length; i++) {
        lineSplit[i] = Solution.replace(lineSplit[i]);
        text.append(lineSplit[i] + " ");
        }
        text.append(System.lineSeparator());
        }*/
