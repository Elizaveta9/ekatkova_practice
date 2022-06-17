package com.katkova.ekatkova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseOfficeFilter implements Response{
    private Long id;
    private String name;
    private Boolean isActive;
}
