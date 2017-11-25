package com.javarush.task.task27.task2712.kitchen;



import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Victor on 07.11.2017.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMessage("Start cooking - " + order);
        Order order1 = (Order) order;
        String tabletName = order1.getTablet().toString();
        String cookName = name;
        int cookingTimeSeconds = order1.getTotalCookingTime();
        List<Dish> cookingDishs = order1.getDishes();
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(tabletName, cookName,
                cookingTimeSeconds, cookingDishs);
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
        setChanged();
        notifyObservers(order);
    }
}
