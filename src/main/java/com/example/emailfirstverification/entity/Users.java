package com.example.emailfirstverification.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Users {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean enabled;

}
