package com.teksytems.capstone.formbeans;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderFormBean { 
    private Integer id;
    private Date orderDate;
    private Integer userId;
    private String comments;
    private String status;
    
}