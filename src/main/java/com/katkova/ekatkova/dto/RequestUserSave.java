package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestUserSave implements Request {
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private Long docCode;
    private String docNumber;
    private String docDate;
    private Long countryCode;
    private Boolean isIdentified;
}
