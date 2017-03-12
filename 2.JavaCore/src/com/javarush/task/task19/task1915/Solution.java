package com.javarush.task.task19.task1915;

/* 
Дублируем текст
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна дублировать вывод всего текста в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        PrintStream realStream = System.out;

        ByteArrayOutputStream fakeText = new ByteArrayOutputStream();

        PrintStream fakeStream = new PrintStream(fakeText);
        System.setOut(fakeStream);

        testString.printSomething();

        FileOutputStream fileInputStream = new FileOutputStream(rd.readLine());
        String fake = fakeText.toString();

        fileInputStream.write(fake.getBytes());


        System.setOut(realStream);
        System.out.println(fake);
        rd.close();
        fileInputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
/*
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();

        reader.close();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();



        FileOutputStream writer = new FileOutputStream(new File(file));

        writer.write(outputStream.toString().getBytes());

        System.setOut(consoleStream);
        System.out.println(outputStream.toString());
        writer.close();




    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
*/

