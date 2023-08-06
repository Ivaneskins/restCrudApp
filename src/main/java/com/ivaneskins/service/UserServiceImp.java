package com.ivaneskins.service;

import com.ivaneskins.dao.UserDao;
import com.ivaneskins.dao.UserDaoImp;
import com.ivaneskins.model.User;

import java.util.List;

public class UserServiceImp implements UserService {

    private UserDao userDao = new UserDaoImp();
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
