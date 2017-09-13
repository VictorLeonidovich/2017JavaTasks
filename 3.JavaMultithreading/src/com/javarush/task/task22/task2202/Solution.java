package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 4 пробелов должно возникнуть
 исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
 которое следует после 4-го пробела.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.split(" ").length < 5) {throw new TooShortStringException();}
        //System.out.println(string.split(" ").length);
        int i = 0;
        int rez = 0;
        while (i < 4){
            rez = string.indexOf(" ", rez + 1);
            i++;
        }
if (string.split(" ").length == 5){return string.substring(string.indexOf(" ", 0) + 1, string.length());}else{
        return string.substring(string.indexOf(" ", 0) + 1, string.indexOf(" ", rez + 1));}
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
