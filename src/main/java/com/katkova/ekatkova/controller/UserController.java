package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.RequestUserRegistration;
import com.katkova.ekatkova.dto.ResponseResult;
import com.katkova.ekatkova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult registerUser(@RequestBody RequestUserRegistration user){
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult("error");
        }
        return new ResponseResult("success");
    }
}
