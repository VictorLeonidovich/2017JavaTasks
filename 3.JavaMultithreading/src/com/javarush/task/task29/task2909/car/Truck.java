package com.javarush.task.task29.task2909.car;

/**
 * Created by Victor on 18.09.2017.
 */
public class Truck extends Car  {
    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }

    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }
}
