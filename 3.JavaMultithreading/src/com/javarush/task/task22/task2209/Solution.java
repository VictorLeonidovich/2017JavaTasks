package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе getLine должен быть использован StringBuilder
3. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы параметры(слова).
4. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
5. Вывод на экран должен соответствовать условию задачи.
*/
//https://github.com/tyomakr/JavaRushHomeWork/blob/master/src/com/javarush/test/level22/lesson09/task03/Solution.java
public class Solution
{
    public static void main(String[] args)
    {
        String[] wordsArray = new String[0];
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            List<String> words = new ArrayList<>();
            while (fileReader.ready())
            {
                String line = fileReader.readLine();
                words.addAll(Arrays.asList(line.split(" ")));
            }
            fileReader.close();
            wordsArray = words.toArray(new String[words.size()]);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        StringBuilder result = getLine(wordsArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (words == null)
            return resultStringBuilder;
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        int cycleCounter = 0;
        while (!wordList.isEmpty())
        {
            //находим первый случайный элемент
            if (resultStringBuilder.toString().equals(""))
            {
                int randomIndex = (int) (Math.random() * wordList.size());
                resultStringBuilder.append(wordList.get(randomIndex));
                wordList.remove(randomIndex);
            }

            //создаём временный лист для случайного перебора оставшихся элементов
            List<String> tempList = new ArrayList<>();
            tempList.addAll(wordList);
            //перебираем оставшиеся элементы в случайном порядке
            while (!tempList.isEmpty())
            {
                int randomIndex = (int) (Math.random() * tempList.size());
                String word = tempList.get(randomIndex);

                if (resultStringBuilder.toString().toLowerCase().charAt(resultStringBuilder.length() - 1) ==
                        word.toLowerCase().charAt(0))
                {
                    resultStringBuilder.append(" ").append(word);
                    //удаляем этот же элемент в основном листе
                    wordList.remove(word);
                }
                tempList.remove(randomIndex);
            }
            cycleCounter++;

            //если итераций уже прошло больше чем слов в изначальном списке, то повторяем всё заново
            if (cycleCounter > words.length)
            {
                wordList.clear();
                Collections.addAll(wordList, words);
                resultStringBuilder.delete(0, resultStringBuilder.length());
                cycleCounter = 0;
            }
        }

        return resultStringBuilder;
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //...
        Scanner scanner = new Scanner(System.in);


        StringBuilder result = getLine(new Scanner(new FileReader(scanner.nextLine())).nextLine().split(" "));
        System.out.println(result.toString());

        scanner.close();

    }
    public static StringBuilder getLine(String... words){
        //System.out.println(Arrays.toString(words));
        StringBuilder result = new StringBuilder();
        if (words.length == 0){return result.append("");}
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().charAt(0) == 'а'){
                result.append(words[i]);
                words[i] = "";
            }
        }
        for (int j = 0; j < words.length; j++) {


        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("") && result.toString().toLowerCase().charAt(result.toString().length() - 1) == words[i].toLowerCase().charAt(0)){
                result.append(" ").append(words[i]);
                words[i] = "";
            }

        }
        }

        return result;
    }

}
*/



/*
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        //Scanner scanner = new Scanner(new FileReader(new File(reader.readLine()))))


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));

        StringBuilder result = getLine(reader2.readLine().split(" "));
        System.out.println(result.toString());
        reader2.close();
        reader.close();


    }

    public static StringBuilder getLine(String... words) {

        StringBuilder stringBuilder = new StringBuilder();
        if (words.length == 0) {
            return stringBuilder;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().charAt(0) == 'а') {
                stringBuilder.append(words[i]);
                words[i] = "";
                break;
            }
        }

        for (int j = 0; j < words.length; j++) {

            for (int i = 0; i < words.length; i++) {

                if (!words[i].equals("")) {
                    if ((stringBuilder.toString().toLowerCase().charAt(stringBuilder.toString().length() - 1)) == words[i].toLowerCase().charAt(0)) {
                        stringBuilder.append(" ").append(words[i]);
                        words[i] = "";
                    }
                }
            }
        }
        */
/*for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                if (!words[i].equals("") && !words[j].equals("") && !words[i].equals(words[j])){
                    if ((words[i].toLowerCase().charAt(words[i].length() - 1)) == (words[j].toLowerCase().charAt(0))){
                        stringBuilder.append(words[j]).append(" ");
                        words[i] = "";
                        words[j] = "";
                        //continue;
                    }
                }


            }

        }*//*


        //System.out.println(Arrays.toString(words));

        return stringBuilder;
    }
}
*/
