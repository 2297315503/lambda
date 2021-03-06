package com.lk.lambda.controller;

import com.lk.lambda.common.result.JsonResult;
import com.lk.lambda.model.User;
import com.lk.lambda.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends  BaseController{
    private IUserService userService ;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public JsonResult getUserList(){
        return renderSuccess(userService.selectList(null));
    }

    @PutMapping("/user/create")
    public JsonResult createUser (@RequestParam User user ){
        return renderSuccess(userService.insert(user));
    }

    @GetMapping("/test")
    public String test ( ){
        return "test";
    }

}
