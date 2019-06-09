package com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Please feel the name")
    private String name;

    @NotBlank(message = "Email is blank")
    @Email(message = "email format wrong!!!")
    private String email;

    private String birthplace;
    private String birthdate;
    private String address;

    private Long gender;
    private Long position;
}
