package com.katkova.ekatkova.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestUserRegistration {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
}
