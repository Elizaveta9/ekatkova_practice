package com.katkova.ekatkova.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseOrganizationFilter implements Response{
    private Long id;
    private String name;
    private Boolean isActive;
}
