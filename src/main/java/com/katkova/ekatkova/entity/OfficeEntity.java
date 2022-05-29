package com.katkova.ekatkova.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "office")
public class OfficeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;
}
