package com.teksytems.capstone.database.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFormBean {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String job;
}
