package com.spark.miaosha.web;

import com.spark.miaosha.amqp.OrderSender;
import com.spark.miaosha.amqp.RabbitMQSender;
import com.spark.miaosha.model.User;
import com.spark.miaosha.model.Users;
import com.spark.miaosha.redis.RedisClusterService;
import com.spark.miaosha.redis.UserKey;
import com.spark.miaosha.result.Result;
import com.spark.miaosha.redis.RedisService;
import com.spark.miaosha.service.UserService;
import com.spark.miaosha.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisClusterService redisClusterService;

    @Autowired
    private OrderSender orderSender;

    @Autowired
    private UsersService usersService;

    @ResponseBody
    public String send(@RequestBody String message) {
        //rabbitMQSender.send(message);
        return "";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result<String> login(HttpServletRequest request) {


        List<User> userList = new ArrayList<User>();

        userList.add(new User(1, "张三"));
        userList.add(new User(2, "李四"));
        userList.add(new User(3, "王五"));
        userList.add(new User(4, "赵六"));
        userList.add(new User(5, "周杰伦"));
        userList.add(new User(6, "刘德华"));
        userList.add(new User(7, "郭富城"));
        userList.add(new User(8, "张学友"));
        userList.add(new User(9, "黎明"));
        userList.add(new User(10, "邓超"));
        userList.add(new User(11, "王祖蓝"));


        userList.stream().forEach(user -> {
            redisClusterService.set(UserKey.GET_BY_ID, user.getId() + "", user);
            System.out.println("key:" + UserKey.GET_BY_ID + user.getId());
        });

        //orderSender.send("hello,hhhh");
        return new Result<String>("success");
    }

    @RequestMapping("/getUser/{userKey}")
    @ResponseBody
    public Result<User> getUser(@PathVariable("userKey") String userKey) {
        User user = redisClusterService.get(UserKey.GET_BY_ID, userKey, User.class);
        return new Result<User>(user);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Result<User> getUserById(@PathVariable("id") int id) {
        return Result.success(userService.getUserById(id));
    }

    @RequestMapping("/tx")
    public void tx() {
        userService.testTransaction();
    }

    @RequestMapping("/userList")
    @ResponseBody
    public List<User> list() {
        return userService.getUserList();
    }

    @RequestMapping("/findUserByPage")
    @ResponseBody
    public List<Users> findUserByPage() {
        return usersService.findUserByPage();
    }

}
