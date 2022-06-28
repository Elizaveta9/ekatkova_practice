package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUserId implements Response {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private Boolean isIdentified;
    private String docName;
    private String docNumber;
    private String docDate;
    private String countryName;
    private String countryCode;
}
