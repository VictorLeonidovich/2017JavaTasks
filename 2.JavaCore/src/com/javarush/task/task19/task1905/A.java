package com.javarush.task.task19.task1905;

/**
 * Created by Victor on 09.02.2017.
 */
public class A {

    public static void main(String[] args) {

        System.out.println("callto://+" + "+38(050)123-45-67".replaceAll("[^\\d]",""));
    }
}
