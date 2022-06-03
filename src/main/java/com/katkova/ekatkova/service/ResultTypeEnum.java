package com.katkova.ekatkova.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultTypeEnum {
    SUCCESS("success"),
    ERROR("error"),
    USER_ALREADY_EXIST("error: user already exist");

    private String result;
}
