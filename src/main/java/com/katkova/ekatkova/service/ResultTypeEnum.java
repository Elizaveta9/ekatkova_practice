package com.katkova.ekatkova.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultTypeEnum {
    SUCCESS("success"),
    ERROR("error"),
    USER_ALREADY_EXIST("error: user already exist"),

    PARAMETER_IS_MISSING_OR_EMPTY("error: some parameters are missing or empty"),
    INN_ALREADY_REGISTERED("error: inn is already registered");

    private String result;
}
