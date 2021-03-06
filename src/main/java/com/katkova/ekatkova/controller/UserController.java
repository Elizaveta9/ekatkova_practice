package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.service.ResultTypeEnum;
import com.katkova.ekatkova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response registerUser(@RequestBody @Valid RequestUserRegistration user,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseResult(ResultTypeEnum.PARAMETER_IS_MISSING_OR_EMPTY);
        }
        if (userService.hasSameUserLogin(user.getLogin())) {
            return new ResponseResult(ResultTypeEnum.USER_ALREADY_EXIST);
        }
        userService.createActivationCode(user);
        return userService.saveUser(user);
    }

    @GetMapping("/activation")
    public String activation(@RequestParam String code, @RequestParam String login) {
        return userService.checkActivation(code, login);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody RequestLogin requestLogin) {
        if (userService.hasUserByLoginAndPassword(requestLogin.getLogin(), requestLogin.getPassword())) {
            return new ResponseResult(ResultTypeEnum.SUCCESS);
        } else {
            return new ResponseResult(ResultTypeEnum.ERROR);
        }
    }

    @GetMapping("/user/list")
    public List<ResponseUserFilter> findUserUsingFilter(@RequestParam(required = true) Long officeId,
                                                        @RequestParam(required = false) String firstName,
                                                        @RequestParam(required = false) String lastName,
                                                        @RequestParam(required = false) String middleName,
                                                        @RequestParam(required = false) Long docCode,
                                                        @RequestParam(required = false) Long countryCode) {
        return userService.findAllUsingFilter(officeId, firstName, lastName, middleName, docCode, countryCode);
    }

    @GetMapping("/user/{id}")
    public Response findUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/user/update")
    public Response updateUser(@RequestBody RequestUserUpdate user){
        return userService.update(user);
    }

    @PostMapping("/user/save")
    public Response saveUser(@RequestBody RequestUserSave user){
        return userService.saveUser(user);
    }
}
