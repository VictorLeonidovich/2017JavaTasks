package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 03.11.2017.
 */
public class ConsoleHelper {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //для вывода message в консоль
    public static void writeMessage(String message){
        System.out.println(message);
    }
    //для чтения строки с консоли
    public static String readString() throws IOException {
        return bufferedReader.readLine();


    }
    //просит пользователя выбрать блюдо и добавляет его в список
     public static List<Dish> getAllDishesForOrder() throws IOException {
         writeMessage(Dish.allDishesToString());
         writeMessage("Enter the dish name, enter 'exit' to exit:");
         List<Dish> tempDishList = new ArrayList<>();
         while (true){
             String tempDish = readString();
             if ("exit".equalsIgnoreCase(tempDish)){
                 break;
             }
             try {
                 tempDishList.add(Dish.valueOf(tempDish));
             }catch (Exception e){
                 writeMessage("There is no such dish!");
             }
         }
         return tempDishList;

    }
}
