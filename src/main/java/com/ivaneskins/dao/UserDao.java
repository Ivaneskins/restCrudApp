package com.ivaneskins.dao;

import com.ivaneskins.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);


    User getUser(int id);
}
