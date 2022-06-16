package com.katkova.ekatkova.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestOrganizationUpdate {
    private Long id;
    private String name;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;
}
