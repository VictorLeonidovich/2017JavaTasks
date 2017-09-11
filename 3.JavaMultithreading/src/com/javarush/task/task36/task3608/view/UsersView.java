package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

/**
 * Created by Victor on 11.09.2017.
 */
public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
for (User data : modelData.getUsers()){
    System.out.print("\t");
    System.out.println(data.toString());
}
        System.out.println("===================================================");
    }

   public void fireEventShowAllUsers(){
       controller.onShowAllUsers();

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }
}
