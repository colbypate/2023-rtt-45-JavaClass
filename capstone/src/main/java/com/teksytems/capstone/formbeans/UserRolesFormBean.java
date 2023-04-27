package com.teksytems.capstone.formbeans;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRolesFormBean {

    private Integer id;

    private Integer userId;

    private String roleName;
}
