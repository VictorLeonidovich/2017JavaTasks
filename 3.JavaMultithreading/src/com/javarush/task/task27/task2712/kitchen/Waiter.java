package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Victor on 08.11.2017.
 */
public class Waiter implements Observer {
    @Override
    public void update(Observable cook, Object order) {
        System.out.println(order + " was cooked by " + cook);
    }
}
