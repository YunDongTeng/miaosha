package com.spark.miaosha.web;

import com.spark.miaosha.result.CodeMsg;
import com.spark.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        return "list...";
    }

    @RequestMapping("/test")
    @ResponseBody
    public Result<String> test() {
        //return new Result<String>(200, "success", "hello,this is imooc");
        return Result.success("hello this imooc");
    }

    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error() {
        //   return new Result<String>(500100, "no session error");
        return Result.error(CodeMsg.MIAOSHA_ERROR);
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "jack");
        return "index";
    }

}
