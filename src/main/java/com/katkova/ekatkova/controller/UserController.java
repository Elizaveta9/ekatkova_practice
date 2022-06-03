package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.RequestUserRegistration;
import com.katkova.ekatkova.dto.ResponseResult;
import com.katkova.ekatkova.service.ResultTypeEnum;
import com.katkova.ekatkova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult registerUser(@RequestBody RequestUserRegistration user) {
        userService.saveUser(user);
        return new ResponseResult(ResultTypeEnum.SUCCESS);
    }
}
