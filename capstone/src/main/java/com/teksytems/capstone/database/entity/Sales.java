package com.teksytems.capstone.database.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="sales")
public class Sales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="user_id")
    private Integer UserId;

    @Column(name="inventory_id")
    private Integer inventoryId;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price_per_unit")
    private Integer pricePerUnit;

    @Column(name="sale_date")
    private Date saleDate;

    @Column(name="comments")
    private String comments;
    
}
