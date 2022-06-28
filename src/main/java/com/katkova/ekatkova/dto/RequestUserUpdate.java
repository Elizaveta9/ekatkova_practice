package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestUserUpdate implements Request{
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String docDate;
    private Long docCode;
    private String docNumber;
    private Long countryCode;
    private Long officeId;
}
