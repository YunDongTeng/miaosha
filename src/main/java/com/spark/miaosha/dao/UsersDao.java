package com.spark.miaosha.dao;

import com.spark.miaosha.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 2018/2/8.
 */
@Mapper
public interface UsersDao {

    @Select("select id,username,account,sex,email,mobile from users limit 378322,120")
    List<Users> findUserByPage();

}
