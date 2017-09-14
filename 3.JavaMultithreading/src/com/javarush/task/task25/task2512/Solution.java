package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        //list.add(e);
        while(e != null){
            list.add(e);
            e = e.getCause();
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i).getClass().getName() + ": " + list.get(i).getMessage());
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
