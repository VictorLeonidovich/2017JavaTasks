package com.javarush.task.task22.task2212;



/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
//https://github.com/alexilyenko/JavaRush/blob/master/src/com/javarush/test/level22/lesson13/task03/Solution.java
        return  (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") || telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");

        /*if (telNumber == null) {
            return false;
        }
        String digits = telNumber.replaceAll("\\D", "");

        //System.out.println(digits);
        //1)++ если номер начинается с ‘+‘, то он содержит 12 цифр
        //System.out.println("");
        if (telNumber.charAt(0) == '+') {
            if (digits.length() != 12) {
                return false;
            }
        } else
            //2)++ если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
            if (telNumber.charAt(0) == '(' || telNumber.substring(0, 1).matches("\\d")) {
                if (digits.length() != 10) {
                    return false;
                }
            }
        //7)++ номер заканчивается на цифру
        //System.out.println(telNumber.substring(telNumber.length() - 1, telNumber.length()));
        if (!telNumber.substring(telNumber.length() - 1, telNumber.length()).matches("\\d")) {
            return false;
        }
        //3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
        if (
            telNumber.matches(".*--.*|.*-.*-.*-.*") ||
        // 4)++  может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
             (telNumber.matches(".*\\(.*\\).*") && !telNumber.matches("[^-]*\\(.*\\).*")) || telNumber.matches(".*\\).*\\(.*") ||
        //5)++  скобки внутри содержат четко 3 цифры
             (telNumber.matches(".*\\(.*\\).*") && !telNumber.matches(".*\\(\\d{3}\\).*")) ||
        //6)++ номер не содержит букв
             telNumber.matches(".*[a-zA-Zа-яА-Я]+.*"))
        {
            return false;
        }


        return true;*/
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 - true: -----" + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - true: -----" + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - true: -----" + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - true: -----" + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - false: -----" + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - false: -----" + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - false: -----" + checkTelNumber("050xxx4567"));
        System.out.println("050123456 - false: -----" + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - false: -----" + checkTelNumber("(0)501234567"));
        System.out.println("MY -- (033)5my034567 - false: -----" + checkTelNumber("0335(034)я567"));

    }
}
