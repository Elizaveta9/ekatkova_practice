package com.katkova.ekatkova.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestOrganizationSave implements Request{
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String inn;

    @NotNull
    @NotEmpty
    private String kpp;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    private String phone;

    @NotNull
    private Boolean isActive;
}
