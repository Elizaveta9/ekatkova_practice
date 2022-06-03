package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.RequestUserRegistration;
import com.katkova.ekatkova.dto.ResponseResult;
import com.katkova.ekatkova.service.ResultTypeEnum;
import com.katkova.ekatkova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult registerUser(@RequestBody @Valid RequestUserRegistration user,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseResult(ResultTypeEnum.ERROR);
        }
        if (userService.hasSameUserLogin(user.getLogin())){
            return new ResponseResult(ResultTypeEnum.USER_ALREADY_EXIST);
        }
        userService.saveUser(user);
        return new ResponseResult(ResultTypeEnum.SUCCESS);
    }
}
