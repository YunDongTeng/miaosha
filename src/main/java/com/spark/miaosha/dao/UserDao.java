package com.spark.miaosha.dao;


import com.spark.miaosha.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select id,name from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name) values(#{id},#{name})")
    int insertUser(User user);

    @Select("select id,name from user")
    List<User> getUserList();

}
