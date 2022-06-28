package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseUserFilter implements Response{
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
}
