package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.RequestUserRegistration;
import com.katkova.ekatkova.entity.UserEntity;
import com.katkova.ekatkova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public void saveUser(RequestUserRegistration userDto) {
        UserEntity userEntity = dtoConvertor.toEntity(userDto, UserEntity.class);
        userRepository.save(userEntity);
    }

    public boolean hasSameUserLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public boolean hasUserByLoginAndPassword(String login, String password){
        return userRepository.existsByLoginAndPassword(login, password);
    }
}
