package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

/**
 * Created by Victor on 29.10.2017.
 */
public class Restaurant {
    public static void main(String[] args) {
        //new Tablet(5).createOrder();
        Cook cook = new Cook("George");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.createOrder();

    }
}
