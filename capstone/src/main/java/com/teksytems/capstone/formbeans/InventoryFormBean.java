package com.teksytems.capstone.formbeans;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InventoryFormBean { 
    private Integer id;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
    private String photoURL;
    
}
