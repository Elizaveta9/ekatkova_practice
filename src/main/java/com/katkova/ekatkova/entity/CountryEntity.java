package com.katkova.ekatkova.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "countries")
public class CountryEntity {
    @Id
    private Long code;
    private String name;
    private String fullname;
    private String alpha2;
    private String alpha3;
}


