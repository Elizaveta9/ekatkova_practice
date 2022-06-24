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
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private Boolean isIdentified;
    private String activationCode;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity office;

    @ManyToOne
    @JoinColumn(name = "doc_code")
    private DocEntity doc;
    private String docNumber;
    private String docDate;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private CountryEntity country;
}
