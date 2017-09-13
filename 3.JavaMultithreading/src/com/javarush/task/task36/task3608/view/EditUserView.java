package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Victor on 12.09.2017.
 */
public class EditUserView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");

            System.out.print("\t");
            System.out.println(modelData.getActiveUser().toString());

        System.out.println("===================================================");
    }
    public void fireEventUserDeleted(long id)
    {
        controller.onUserDelete(id);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }
}
