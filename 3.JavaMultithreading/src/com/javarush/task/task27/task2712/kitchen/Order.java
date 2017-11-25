package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Victor on 03.11.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        return "Your order: " + dishes.toString() + " of " + tablet.toString() + ", cooking time " + getTotalCookingTime() + "min";

    }

    public int getTotalCookingTime() {
        int tempTotalDuration = 0;
        for (Dish dish : dishes) {
            tempTotalDuration = tempTotalDuration + dish.getDuration();
        }
        return tempTotalDuration;
    }

    public boolean isEmpty() {
        return dishes.size() == 0;

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
