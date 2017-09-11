package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Victor on 16.08.2017.
 */
public interface View {
    public void refresh(ModelData modelData);
    public void setController(Controller controller);

}
