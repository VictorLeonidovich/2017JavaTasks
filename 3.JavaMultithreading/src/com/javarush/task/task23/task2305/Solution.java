package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        /*innerClasses[1] = new Solution[2];*/
        return null;/*{new Solution(), new Solution()}*/
    }

    public static void main(String[] args) {

    }
}
