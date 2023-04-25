package com.teksytems.capstone.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "sale_details")
public class SaleDetails {

    @Id
    @Column(name = "sale_id", insertable=false, updatable=false)
    private Integer saleId;

    @Id
    @Column(name = "inventory_id", insertable=false, updatable=false)
    private Integer inventoryId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price", columnDefinition = "decimal", precision = 10, scale = 2)
    private Double totalPrice;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id", nullable = true)
	private Inventory inventory;

    @ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_id", nullable = true)
	private Sales sales;
}