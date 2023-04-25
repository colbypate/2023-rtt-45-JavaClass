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
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id", insertable=false, updatable=false)
    private Integer orderId;


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
	@JoinColumn(name = "order_id", nullable = true)
	private Orders orders;
}
	
