package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseOfficeId implements Response{
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;
}
