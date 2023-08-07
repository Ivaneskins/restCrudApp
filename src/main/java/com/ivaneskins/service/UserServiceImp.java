package com.ivaneskins.service;

import com.ivaneskins.dao.UserDao;
import com.ivaneskins.dao.UserDaoImp;
import com.ivaneskins.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

//    @Transactional //метод должен выполняться в транзакции (без этого Hibernate работать откажется):
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
