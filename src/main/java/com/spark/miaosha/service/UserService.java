package com.spark.miaosha.service;

import com.spark.miaosha.dao.UserDao;
import com.spark.miaosha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void testTransaction() {

        User u1 = new User();
        u1.setId(2);
        u1.setName("李四");

        userDao.insertUser(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("王五");

        userDao.insertUser(u2);

    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }


}
