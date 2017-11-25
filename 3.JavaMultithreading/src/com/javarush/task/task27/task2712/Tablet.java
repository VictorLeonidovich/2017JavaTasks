package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import sun.rmi.runtime.Log;


import java.io.IOException;
import java.util.Observable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Victor on 03.11.2017.
 */
public class Tablet extends Observable{
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
                try {
                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                }catch (NoVideoAvailableException e){
                    StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()*60));
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            createOrder();
        }

        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }


}
