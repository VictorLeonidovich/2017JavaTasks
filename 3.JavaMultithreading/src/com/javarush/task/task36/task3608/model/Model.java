package com.javarush.task.task36.task3608.model;

/**
 * Created by Victor on 15.08.2017.
 */
public interface Model {
    public ModelData getModelData();
    public void loadUsers();
    public void loadUserById(long userid);

    public void loadDeletedUsers();

    public void deleteUserById(long id);

    public void changeUserData(String name, long id, int level);
}
