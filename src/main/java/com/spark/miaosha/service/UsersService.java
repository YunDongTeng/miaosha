package com.spark.miaosha.service;

import com.spark.miaosha.dao.UsersDao;
import com.spark.miaosha.model.User;
import com.spark.miaosha.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/2/8.
 */
@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    public List<Users> findUserByPage(){
        return usersDao.findUserByPage();
    }
}
