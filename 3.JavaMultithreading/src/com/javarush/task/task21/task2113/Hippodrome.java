package com.javarush.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Victor on 15.06.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){for (Horse horse : horses){horse.move();}}
    public void print(){for (Horse horse : horses){horse.print();}
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }}
    public Horse getWinner(){
        double dist = 0;
        Horse winner = null;
        for (Horse horse : horses){
            if (dist < horse.getDistance()) {dist = horse.getDistance(); winner = horse;};
        }
        return winner;}
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        //Horse horse1 = new Horse("1", 3, 0);

        game = new Hippodrome(Arrays.asList(new Horse("1", 3, 0),new Horse("2", 3, 0),new Horse("3", 3, 0)));

        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
